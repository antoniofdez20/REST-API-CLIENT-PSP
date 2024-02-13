package models;

public class Videogame
{
    private int id;
    private String title;
    private String year;
    private String modality;
    private String company;

    public Videogame(int id, String title, String year, String modality, String company)
    {
        this.id = id;
        this.title = title;
        this.year = year;
        this.modality = modality;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", modality='" + modality + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
