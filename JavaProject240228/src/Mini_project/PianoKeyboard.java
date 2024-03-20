package Mini_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;

public class PianoKeyboard extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 300;
    private static final int NUM_WHITE_KEYS = 7;
    private static final int NUM_BLACK_KEYS = 5;
    private static final int WHITE_KEY_WIDTH = 100;
    private static final int WHITE_KEY_HEIGHT = 250;
    private static final int BLACK_KEY_WIDTH = 60;
    private static final int BLACK_KEY_HEIGHT = 150;
    private static final int[] WHITE_KEY_CODES = 
        { KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_F, KeyEvent.VK_G, KeyEvent.VK_H, KeyEvent.VK_J };
    private static final int[] BLACK_KEY_CODES = 
        { KeyEvent.VK_W, KeyEvent.VK_E, KeyEvent.VK_T, KeyEvent.VK_Y, KeyEvent.VK_U };
    private static final String[] WHITE_NOTES = 
        { "C", "D", "E", "F", "G", "A", "B" };
    private static final String[] BLACK_NOTES = 
        { "C#", "D#", "F#", "G#", "A#" };
    private static final String[] SOUND_FILES = 
        { "C.wav", "D.wav", "E.wav", "F.wav", "G.wav", "A.wav", "B.wav", 
          "C_Sharp.wav", "D_Sharp.wav", "F_Sharp.wav", "G_Sharp.wav", "A_Sharp.wav" };
    private Clip[] clips;

    public PianoKeyboard() {
        super("Piano Keyboard");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // 절대 위치 지정을 위해 레이아웃을 null로 설정

        // 검은색 건반 키 생성 및 추가
        for (int i = 0; i < NUM_BLACK_KEYS; i++) {
            JButton blackKeyButton = new JButton();
            blackKeyButton.setBounds((i * (WHITE_KEY_WIDTH * 2)) + (WHITE_KEY_WIDTH * 7 / 10), 0, BLACK_KEY_WIDTH, BLACK_KEY_HEIGHT);
            blackKeyButton.setBackground(Color.BLACK);
            blackKeyButton.setFocusable(false);
            blackKeyButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            blackKeyButton.addActionListener(new KeyButtonListener(NUM_WHITE_KEYS + i));
            add(blackKeyButton);
        }

        // 흰색 건반 키 생성 및 추가
        for (int i = 0; i < NUM_WHITE_KEYS; i++) {
            JButton whiteKeyButton = new JButton();
            whiteKeyButton.setBounds(i * WHITE_KEY_WIDTH, 0, WHITE_KEY_WIDTH, WHITE_KEY_HEIGHT);
            whiteKeyButton.setBackground(Color.WHITE);
            whiteKeyButton.setFocusable(false);
            whiteKeyButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            whiteKeyButton.addActionListener(new KeyButtonListener(i));
            add(whiteKeyButton);

            JLabel noteLabel = new JLabel(WHITE_NOTES[i]);
            noteLabel.setBounds((i * WHITE_KEY_WIDTH) + (WHITE_KEY_WIDTH / 3), WHITE_KEY_HEIGHT, 30, 20);
            add(noteLabel);
        }

        // 음원 로드 및 초기화
        initializeClips();

        // 키보드 입력을 위한 KeyListener 등록
        addKeyListener(this);
    }

    // 음원 초기화 메소드
    private void initializeClips() {
        try {
            clips = new Clip[NUM_WHITE_KEYS + NUM_BLACK_KEYS];
            AudioInputStream audioInputStream;
            for (int i = 0; i < NUM_WHITE_KEYS + NUM_BLACK_KEYS; i++) {
                audioInputStream = AudioSystem.getAudioInputStream(PianoKeyboard.class.getResource(SOUND_FILES[i]));
                clips[i] = AudioSystem.getClip();
                clips[i].open(audioInputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 키보드 입력 처리 메소드
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        for (int i = 0; i < NUM_WHITE_KEYS + NUM_BLACK_KEYS; i++) {
            if (keyCode == WHITE_KEY_CODES[i] || keyCode == BLACK_KEY_CODES[i - NUM_WHITE_KEYS]) {
                playSound(i);
                return;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    // 소리 재생 메소드
    private void playSound(int index) {
        if (clips[index].isRunning())
            clips[index].stop();
        clips[index].setFramePosition(0);
        clips[index].start();
    }

    // 각 건반 키의 ActionListener 구현
    private class KeyButtonListener implements ActionListener {
        private int index;

        public KeyButtonListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            playSound(index);
        }
    }

    // 메인 메소드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PianoKeyboard piano = new PianoKeyboard();
            piano.setVisible(true);
        });
    }
}