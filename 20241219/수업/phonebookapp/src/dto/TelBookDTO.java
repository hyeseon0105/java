package dto;

import java.time.LocalDateTime;

public class TelBookDTO {
    private Long id;
    private String name;
    private int age;
    private String addres;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

    @Override
    public String toString() {
        String str = String.format("%d\t %s \t %d \t %s \t %s \t %s \t %s", id, name,age,addres,phone,createdAt,updateAt);
        return str;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
