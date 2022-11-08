package model;


import lombok.Data;

@Data
public class Root{
    public String label;
    public String slug;
    public String id;
    public String country_code;
    public String country_name;
    public String city_code;
    public String city_name;
    public boolean is_city;
    public String airport;
    public Object ghost_label;
}