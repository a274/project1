package test.itschool.samsung.ru.eco_lavka;

public class Categories {
    private String name; // название
    private int ImageResource; // ресурс флага

    public Categories(String name, int image){

        this.name=name;
        this.ImageResource=image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResource() {
        return this.ImageResource;
    }

    public void setImageResource(int ImageResource) {
        this.ImageResource = ImageResource;
    }
}

