     
package Mini_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PianoKeyboard extends JFrame implements KeyListener {
    private boolean[] whiteKeyStatus; // 흰 건반의 누름 여부를 나타내는 배열
    private boolean[] blackKeyStatus; // 검은 건반의 누름 여부를 나타내는 배열

    public PianoKeyboard() {
        setTitle("Piano Keyboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 200);
        getContentPane().setBackground(Color.lightGray);
        addKeyListener(this); // 키 리스너 등록

        // 키보드 입력 상태를 나타내는 배열 초기화
        whiteKeyStatus = new boolean[7];
        blackKeyStatus = new boolean[5];
    }

    private void drawKeyboard(Graphics g) {
        int whiteX = 10;
        int blackX = 25;
        int y = 50;
        int whiteWidth = 30;
        int blackWidth = 20;
        int height = 120;
        int blackHeight = 80;

        // 흰 건반 그리기
        for (int i = 0; i < 7; i++) {
            if (whiteKeyStatus[i]) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.WHITE);
            }
            g.fillRect(whiteX, y, whiteWidth, height);
            g.setColor(Color.BLACK);
            g.drawRect(whiteX, y, whiteWidth, height);
            whiteX += whiteWidth;
        }

        for (int i = 0; i < 5; i++) {
            if (blackKeyStatus[i]) {
                g.setColor(Color.YELLOW);
            } else {
                g.setColor(Color.BLACK);
            }
            if (i == 0) {
                blackX = 30;
            } else if (i == 1) {
                blackX = 60;
            } else if (i == 2) {
                blackX = 120;
            } else if (i == 3) {
                blackX = 150;
            } else if (i == 4) {
                blackX = 180;
            }
            g.fillRect(blackX, y, blackWidth, blackHeight);
            g.setColor(Color.WHITE);
            g.drawRect(blackX, y, blackWidth, blackHeight);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawKeyboard(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 사용자가 키를 누를 때 호출
        int keyCode = e.getKeyCode();
        // 건반에 대응하는 키를 누른 상태로 변경하고 소리 재생
        switch (keyCode) {
            case KeyEvent.VK_A:
                whiteKeyStatus[0] = true; // 도
                SoundUtil.playSound("do.wav");
                break;
            case KeyEvent.VK_S:
                whiteKeyStatus[1] = true; // 레
                SoundUtil.playSound("re.wav");
                break;
            case KeyEvent.VK_D:
                whiteKeyStatus[2] = true; // 미
                SoundUtil.playSound("mi.wav");
                break;
            case KeyEvent.VK_F:
                whiteKeyStatus[3] = true; // 파
                SoundUtil.playSound("fa.wav");
                break;
            case KeyEvent.VK_G:
                whiteKeyStatus[4] = true; // 솔
                SoundUtil.playSound("sol.wav");
                break;
            case KeyEvent.VK_H:
                whiteKeyStatus[5] = true; // 라
                SoundUtil.playSound("la.wav");
                break;
            case KeyEvent.VK_J:
                whiteKeyStatus[6] = true; // 시
                SoundUtil.playSound("si.wav");
                break;
            case KeyEvent.VK_W:
                blackKeyStatus[0] = true; // 도#
                SoundUtil.playSound("do_sharp.wav");
                break;
            case KeyEvent.VK_E:
                blackKeyStatus[1] = true; // 레#
                SoundUtil.playSound("re_sharp.wav");
                break;
            case KeyEvent.VK_T:
                blackKeyStatus[2] = true; // 파#
                SoundUtil.playSound("fa_sharp.wav");
                break;
            case KeyEvent.VK_Y:
                blackKeyStatus[3] = true; // 솔#
                SoundUtil.playSound("sol_sharp.wav");
                break;
            case KeyEvent.VK_U:
                blackKeyStatus[4] = true; // 라#
                SoundUtil.playSound("la_sharp.wav");
                break;
        }
        // 화면을 다시 그려서 키를 누른 상태로 업데이트
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 사용자가 키를 눌렀다 뗄 때 호출
        int keyCode = e.getKeyCode();
        // 건반에 대응하는 키를 떼어낸 상태로 변경
        switch (keyCode) {
            case KeyEvent.VK_A:
                whiteKeyStatus[0] = false; // 도
                break;
            case KeyEvent.VK_S:
                whiteKeyStatus[1] = false; // 레
                break;
            case KeyEvent.VK_D:
                whiteKeyStatus[2] = false; // 미
                break;
            case KeyEvent.VK_F:
                whiteKeyStatus[3] = false; // 파
                break;
            case KeyEvent.VK_G:
                whiteKeyStatus[4] = false; // 솔
                break;
            case KeyEvent.VK_H:
            	whiteKeyStatus[5] = false; // 라
                break;
            case KeyEvent.VK_J:
                whiteKeyStatus[6] = false; // 시
                break;
            case KeyEvent.VK_W:
                blackKeyStatus[0] = false; // 도#
                break;
            case KeyEvent.VK_E:
                blackKeyStatus[1] = false; // 레#
                break;
            case KeyEvent.VK_T:
                blackKeyStatus[2] = false; // 파#
                break;
            case KeyEvent.VK_Y:
                blackKeyStatus[3] = false; // 솔#
                break;
            case KeyEvent.VK_U:
                blackKeyStatus[4] = false; // 라#
                break;
        }
        // 화면을 다시 그려서 키를 떼어낸 상태로 업데이트
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 사용하지 않습니다. (여기서는 사용하지 않습니다.)
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PianoKeyboard piano = new PianoKeyboard();
            piano.setVisible(true);
        });
    }
}
