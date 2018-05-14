package hospital;

public class Disease {
    private String diseaseName;
    private String description;

    public Disease(String diseaseName, String description) {
        this.diseaseName = diseaseName;
        this.description = description;
    }

    public String getDiseaseName() {
        return diseaseName;
    }
}
