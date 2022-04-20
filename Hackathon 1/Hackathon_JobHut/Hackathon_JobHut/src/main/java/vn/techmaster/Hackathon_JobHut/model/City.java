package vn.techmaster.Hackathon_JobHut.model;

public enum City {
    HaNoi("Hà nội"),
    HoChiMinh("Hồ Chí Minh"),
    HaiPhong("Hải phòng"),
    DaNang("Đà Nẵng");

    public final String label;
    private City(String label) {
        this.label = label;
    }
}
