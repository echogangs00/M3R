package trashey.recyclerviewtest.model;

//Java representation of our data. to be displayed in the RecylclerView

public class ListItem {

   private String title;
    private String subTitle;

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    private boolean favourite = false;
   private int imageResid;

    public int getImageResid() {
        return imageResid;
    }

    public void setImageResid(int imageResid) {
        this.imageResid = imageResid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
