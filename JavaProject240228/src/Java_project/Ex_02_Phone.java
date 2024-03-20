package Java_project;

class Ex_02_Phone {
    private String name;
    private String tel;
    private String address;

    public Ex_02_Phone(String name, String tel, String address) {
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 전화번호: " + tel + ", 주소: " + address;
    }
}