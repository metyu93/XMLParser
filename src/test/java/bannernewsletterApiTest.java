import Entity.Banner;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by metin.namli on 23.12.2016.
 */
public class bannernewsletterApiTest {

    @Test
    public void LabelCountControlTest() {

        List<Integer> listDev1Area = null;
        List<String> listDev1ImageURLFemale = null;
        List<String> listDev1ImageURLMale = null;
        List<String> listDev1LinkURLFemale = null;
        List<String> listDev1LinkURLMale = null;

        List<Integer> listDev2Area = null;
        List<String> listDev2ImageURLFemale = null;
        List<String> listDev2ImageURLMale = null;
        List<String> listDev2LinkURLFemale = null;
        List<String> listDev2LinkURLMale = null;


        try {
            URL url = new URL("http://dev.catalog.trendyol.com/api/bannernewsletter");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application / json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : "
                        + conn.getResponseCode());
            }

            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();


            scan.close();

            listDev1Area = JsonPath.read(entireResponse, "$.items.[*].Area");
            listDev1ImageURLFemale = JsonPath.read(entireResponse, "$.items.[*].ImageURL.female");
            listDev1ImageURLMale = JsonPath.read(entireResponse, "$.items.[*].ImageURL.male");
            listDev1LinkURLFemale = JsonPath.read(entireResponse, "$.items.[*].LinkURL.female");
            listDev1LinkURLMale = JsonPath.read(entireResponse, "$.items.[*].LinkURL.male");

            System.out.println(listDev1Area.size());
            System.out.println(listDev1ImageURLFemale.size());
            System.out.println(listDev1ImageURLMale.size());
            System.out.println(listDev1LinkURLFemale.size());
            System.out.println(listDev1LinkURLMale.size());

        } catch (Exception e) {
            e.printStackTrace();

        }

        try {
            URL url = new URL("http://dev2.catalog.trendyol.com/api/bannernewsletter");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application / json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : "
                        + conn.getResponseCode());
            }

            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();

            scan.close();

            listDev2Area = JsonPath.read(entireResponse, "$.items.[*].Area");
            listDev2ImageURLFemale = JsonPath.read(entireResponse, "$.items.[*].ImageURL.female");
            listDev2ImageURLMale = JsonPath.read(entireResponse, "$.items.[*].ImageURL.male");
            listDev2LinkURLFemale = JsonPath.read(entireResponse, "$.items.[*].LinkURL.female");
            listDev2LinkURLMale = JsonPath.read(entireResponse, "$.items.[*].LinkURL.male");


        } catch (Exception e) {
            e.printStackTrace();

        }

        if (listDev1Area.size() == listDev2Area.size()) {
            System.out.println("İki ortamda da Area etiketi sayıları aynı");
        } else {
            if (listDev1Area.size() > listDev2Area.size()) {
                System.out.println("Dev2 ortamında Area etiketi " + (listDev1Area.size() - listDev2Area.size()) + " tane eksik");
            } else {
                System.out.println("Dev1 ortamında Area etiketi " + (listDev2Area.size() - listDev1Area.size()) + " tane eksik");
            }
        }

        if (listDev1ImageURLFemale.size() == listDev2ImageURLFemale.size()) {
            System.out.println("İki ortamda da ImageURLFemale etiketi sayıları aynı");
        } else {
            if (listDev1ImageURLFemale.size() > listDev2ImageURLFemale.size()) {
                System.out.println("Dev2 ortamında ImageURLFemale etiketi " + (listDev1ImageURLFemale.size() - listDev2ImageURLFemale.size()) + " tane eksik");
            } else {
                System.out.println("Dev1 ortamında ImageURLFemale etiketi " + (listDev2ImageURLFemale.size() - listDev1ImageURLFemale.size()) + " tane eksik");
            }
        }

        if (listDev1ImageURLMale.size() == listDev2ImageURLMale.size()) {
            System.out.println("İki ortamda da ImageURLMale etiketi sayıları aynı");
        } else {
            if (listDev1ImageURLMale.size() > listDev2ImageURLMale.size()) {
                System.out.println("Dev2 ortamında ImageURLMale etiketi " + (listDev1ImageURLMale.size() - listDev2ImageURLMale.size()) + " tane eksik");
            } else {
                System.out.println("Dev1 ortamında ImageURLMale etiketi " + (listDev2ImageURLMale.size() - listDev1ImageURLMale.size()) + " tane eksik");
            }
        }

        if (listDev1LinkURLFemale.size() == listDev2LinkURLFemale.size()) {
            System.out.println("İki ortamda da LinkURLFemale etiketi sayıları aynı");
        } else {
            if (listDev1LinkURLFemale.size() > listDev2LinkURLFemale.size()) {
                System.out.println("Dev2 ortamında LinkURLFemale etiketi " + (listDev1LinkURLFemale.size() - listDev2LinkURLFemale.size()) + " tane eksik");
            } else {
                System.out.println("Dev1 ortamında LinkURLFemale etiketi " + (listDev2LinkURLFemale.size() - listDev1LinkURLFemale.size()) + " tane eksik");
            }
        }

        if (listDev1LinkURLMale.size() == listDev2LinkURLMale.size()) {
            System.out.println("İki ortamda da LinkURLMale etiketi sayıları aynı");
        } else {
            if (listDev1LinkURLFemale.size() > listDev2LinkURLFemale.size()) {
                System.out.println("Dev2 ortamında LinkURLMale etiketi " + (listDev1LinkURLMale.size() - listDev2LinkURLMale.size()) + " tane eksik");
            } else {
                System.out.println("Dev1 ortamında LinkURLMale etiketi " + (listDev2LinkURLMale.size() - listDev1LinkURLMale.size()) + " tane eksik");
            }
        }

    }

    @Test
    public void equalControlTest() {
        int temp=0;

        int countArea=0, countImageURLFemale=0, countImageURLMale=0, countLinkURLFemale=0, countLinkURLMale=0;

//Dev'den JSON verinin parse edilmesi
        ArrayList<Banner> listBanner=ParseJsonToArraylist("http://dev.catalog.trendyol.com/api/bannernewsletter");

//Dev2'den JSON verinin parse edilmesi
        ArrayList<Banner> listBanner2=ParseJsonToArraylist("http://dev2.catalog.trendyol.com/api/bannernewsletter");

        if (listBanner.size() < listBanner2.size()) {

            temp = listBanner.size();

        }
        else{
            temp=listBanner2.size();
        }


        for (int i = 0; i < temp; i++) {
            if (listBanner.get(i).getArea()!=listBanner2.get(i).getArea()) {
                countArea++;
            }

            if (listBanner.get(i).getImageURLFemaile()!=listBanner2.get(i).getImageURLFemaile()) {
                countImageURLFemale++;
            }

            if (listBanner.get(i).getImageURLMale()!=listBanner2.get(i).getImageURLMale()) {
                countImageURLMale++;
            }

            if (listBanner.get(i).getLinkURLFemale()!=listBanner2.get(i).getLinkURLFemale()) {
                countLinkURLFemale++;
            }

            if (listBanner.get(i).getLinkURLMale()!=listBanner2.get(i).getLinkURLMale()) {
                countLinkURLMale++;
            }
        }

        System.out.println("Bu test ile ortamda yer alan aynı etiketlerdeki veriler karşılaştırılmaktadır!");
        System.out.println("");

        MatchingLists(countArea,"Area");
        MatchingLists(countImageURLFemale,"ImageURLFemale");
        MatchingLists(countImageURLMale,"ImageURLMale");
        MatchingLists(countLinkURLFemale,"LinkURLFemale");
        MatchingLists(countLinkURLMale,"LinkURLMale");


    }

    @Test
    public void LabelEmptyControlTest(){

        ArrayList<Banner> listBanner=ParseJsonToArraylist("http://dev.catalog.trendyol.com/api/bannernewsletter");
        ArrayList<Banner> listBanner2=ParseJsonToArraylist("http://dev2.catalog.trendyol.com/api/bannernewsletter");

        System.out.println("Dev ortamında boşluk kontrolü");
        System.out.println("");
        EmptyLabelControl(listBanner);
        System.out.println("-----------------------------------------------");
        System.out.println("Dev2 ortamında boşluk kontrolü");
        System.out.println("");
        EmptyLabelControl(listBanner2);

    }

    public ArrayList<Banner> ParseJsonToArraylist(String URL) {

        ArrayList<Banner> listBanner = null;

        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application / json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : "
                        + conn.getResponseCode());
            }

            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();


            scan.close();

            listBanner = new ArrayList<Banner>();

            List<Integer> listDevArea = JsonPath.read(entireResponse, "$.items.[*].Area");
            List<String> listDevImageURLFemale = JsonPath.read(entireResponse, "$.items.[*].ImageURL.female");
            List<String> listDevImageURLMale = JsonPath.read(entireResponse, "$.items.[*].ImageURL.male");
            List<String> listDevLinkURLFemale = JsonPath.read(entireResponse, "$.items.[*].LinkURL.female");
            List<String> listDevLinkURLMale = JsonPath.read(entireResponse, "$.items.[*].LinkURL.male");

            for (int i = 0; i < listDevArea.size(); i++) {

                Banner banner = new Banner();
                banner.setArea(listDevArea.get(i));
                banner.setImageURLFemaile(listDevImageURLFemale.get(i));
                banner.setImageURLMale(listDevImageURLMale.get(i));
                banner.setLinkURLFemale(listDevLinkURLFemale.get(i));
                banner.setLinkURLMale(listDevLinkURLMale.get(i));
                listBanner.add(banner);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listBanner;

    }

    public void MatchingLists(int count, String etiket){


        if (count == 0) {

            System.out.println("İki ortamda da "+etiket+ "etiketine'inde ait veriler aynı");;

        } else {

            System.out.println("İki ortamda "+etiket+" etiketine ait aynı olmayan veri sayısı:"+count);

        }

    }

    public void EmptyLabelControl(ArrayList<Banner> listBanner){

        int countArea=0, countImageURLFemale=0, countImageURLMale=0, countLinkURLFemale=0, countLinkURLMale=0;

        listBanner=new ArrayList<Banner>();

        for (int i = 0; i < listBanner.size(); i++) {
            if (listBanner.get(i).getArea()!=0) {
                countArea++;
            }

            if (listBanner.get(i).getImageURLFemaile().equals("") || listBanner.get(i).getImageURLFemaile().equals("null") || listBanner.get(i).getImageURLFemaile().equals(null)) {
                countImageURLFemale++;
            }

            if (listBanner.get(i).getImageURLMale().equals("") ||listBanner.get(i).getImageURLMale().equals("null") || listBanner.get(i).getImageURLMale().equals(null)) {
                countImageURLMale++;
            }

            if (listBanner.get(i).getLinkURLFemale().equals("") || listBanner.get(i).getLinkURLFemale().equals("null") || listBanner.get(i).getLinkURLFemale().equals(null)) {
                countLinkURLFemale++;
            }

            if (listBanner.get(i).getLinkURLMale().equals("") || listBanner.get(i).getLinkURLMale().equals("null") || listBanner.get(i).getLinkURLMale().equals(null)) {
                countLinkURLMale++;
            }
        }

        System.out.println("Area boş etiket sayısı:"+countArea);
        System.out.println("ImageURLFemale boş etiket sayısı:"+countImageURLFemale);
        System.out.println("ImageURLMale boş etiket sayısı:"+countImageURLMale);
        System.out.println("LinkURLFemale boş etiket sayısı:"+countLinkURLFemale);
        System.out.println("LinkURLMale boş etiket sayısı:"+countLinkURLMale);

    }

}