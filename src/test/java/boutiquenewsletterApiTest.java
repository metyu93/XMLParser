import Entity.Boutique;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * Created by metin.namli on 23.12.2016.
 */
public class boutiquenewsletterApiTest {
    @Test

    public void UniqueCountEqualTest(){

        ArrayList<Boutique> listDev=ParseJSONtoArrayList("http://dev.catalog.trendyol.com/api/boutiquenewsletter");
        ArrayList<Boutique> listDev2=ParseJSONtoArrayList("http://dev2.catalog.trendyol.com/api/boutiquenewsletter");

        System.out.println("Dev id count="+listDev.size());
        System.out.println("Dev2 id count:"+listDev2.size());

        if(listDev.size()==listDev2.size()){
            System.out.println("İki ortamdaki id sayıları eşit");
        }
        else{
            System.out.println("İki ortamdaki id sayıları eşit değil!");
        }

    }

    @Test
    public void DataEqualTest(){

        int temp=0;
        int max=0;

        int countid=0, countname=0, countcloseDate=0, countdiscount=0, counttags=0,  countorderMale=0, countorderFemale=0,
        countsmallImageUrlFemale=0, countsmallImageUrlMale=0, countbigImageUrlFemale=0, countbigImageUrlMale=0,
        countlinkUrlFemale=0, countlinkUrlMale=0, countgender=0,  countbrands=0, countcategories=0, countprice=0;

        ArrayList<Boutique> listDev=ParseJSONtoArrayList("http://dev.catalog.trendyol.com/api/boutiquenewsletter");
        ArrayList<Boutique> listDev2=ParseJSONtoArrayList("http://dev2.catalog.trendyol.com/api/boutiquenewsletter");

        if (listDev.size() < listDev2.size()) {

            temp = listDev.size();
            max = listDev2.size();
        }
        else{
            temp = listDev2.size();
            max = listDev.size();
        }


        Random rnd = new Random();
        int dizi[] = new int[10];

        for (int i = 0; i < dizi.length; i++) {
            dizi[i] = rnd.nextInt(temp);
        }

        for (int i=0 ; i<dizi.length ; i++){

            for (int j=0 ; j<temp ; j++){

                if(listDev.get(dizi[i]).getId()==listDev2.get(j).getId()) {

                    if (!listDev.get(dizi[i]).getName().equals(listDev2.get(j).getName())) {
                        countname++;
                    }

                    if (!listDev.get(dizi[i]).getCloseDate().equals(listDev2.get(j).getCloseDate())) {
                        countcloseDate++;
                    }

                    if (!listDev.get(dizi[i]).getDiscount().equals(listDev2.get(j).getDiscount())) {
                        countdiscount++;
                    }

                    if (!listDev.get(dizi[i]).getTags().equals(listDev2.get(j).getTags())) {
                        counttags++;
                    }

                    if (!listDev.get(dizi[i]).getOrderMale().equals(listDev2.get(j).getOrderMale())) {
                        countorderMale++;
                    }

                    if (!listDev.get(dizi[i]).getOrderFemale().equals(listDev2.get(j).getOrderFemale())) {
                        countorderFemale++;
                    }

                    if (!listDev.get(dizi[i]).getSmallImageUrlFemale().equals(listDev2.get(j).getSmallImageUrlFemale())) {
                        countsmallImageUrlFemale++;
                    }

                    if (!listDev.get(dizi[i]).getSmallImageUrlMale().equals(listDev2.get(j).getSmallImageUrlMale())) {
                        countsmallImageUrlMale++;
                    }

                    if (!listDev.get(dizi[i]).getBigImageUrlFemale().equals(listDev2.get(j).getBigImageUrlFemale())) {
                        countbigImageUrlFemale++;
                    }

                    if (!listDev.get(dizi[i]).getBigImageUrlMale().equals(listDev2.get(j).getBigImageUrlMale())) {
                        countbigImageUrlMale++;
                    }

                    if (!listDev.get(dizi[i]).getLinkUrlFemale().equals(listDev2.get(j).getLinkUrlFemale())) {
                        countlinkUrlFemale++;
                    }

                    if (!listDev.get(dizi[i]).getLinkUrlMale().equals(listDev2.get(j).getLinkUrlMale())) {
                        countlinkUrlMale++;
                    }

                    if (!listDev.get(dizi[i]).getGender().equals(listDev2.get(j).getGender())) {
                        countgender++;
                    }

                    if (!listDev.get(dizi[i]).getBrands().equals(listDev2.get(j).getBrands())) {
                        countbrands++;
                    }

                    if (!listDev.get(dizi[i]).getCategories().equals(listDev2.get(j).getCategories())) {
                        countcategories++;
                    }

                    if (!listDev.get(dizi[i]).getPrice().equals(listDev2.get(j).getPrice())) {
                        countprice++;
                    }
                }
            }
        }

        System.out.println("Bu test ile ortamda yer alan aynı etiketlerdeki veriler karşılaştırılmaktadır!");
        System.out.println("");

        MatchingLists(countid,"id");
        MatchingLists(countname,"Name");
        MatchingLists(countcloseDate,"CloseDate");
        MatchingLists(countdiscount,"Discount");
        MatchingLists(counttags,"Tags");
        MatchingLists(countorderFemale,"OrderFemale");
        MatchingLists(countorderMale,"OrderMale");
        MatchingLists(countsmallImageUrlFemale,"SmallImageUrlFemale");
        MatchingLists(countsmallImageUrlMale,"SmallImageUrlMale");
        MatchingLists(countbigImageUrlFemale,"BigImageUrlFemale");
        MatchingLists(countbigImageUrlMale,"BigImageUrlMale");
        MatchingLists(countlinkUrlFemale,"LinkUrlFemale");
        MatchingLists(countlinkUrlMale,"LinkUrlMale");
        MatchingLists(countgender,"Gender");
        MatchingLists(countbrands,"Brands");
        MatchingLists(countcategories,"Categories");
        MatchingLists(countprice,"Price");

    }

    @Test
    public void EmptyTest(){


        ArrayList<Boutique> lstBoutique = ParseJSONtoArrayList("http://dev.catalog.trendyol.com/api/boutiquenewsletter");
        ArrayList<Boutique> lstBoutique2 = ParseJSONtoArrayList("http://dev2.catalog.trendyol.com/api/boutiquenewsletter");

        System.out.println("Dev ortamında boşluk kontrolü");
        System.out.println("");
        EmptyLabelControl(lstBoutique);
        System.out.println("-----------------------------------------------");
        System.out.println("Dev2 ortamında boşluk kontrolü");
        System.out.println("");
        EmptyLabelControl(lstBoutique2);

    }

    @Test
    public void MissingLabelTest(){


        System.out.println("Dev label sayısı kontolü");
        System.out.println("Dev ortamında label sayısı kontrolü");
        System.out.println("");
        JSONLabelCountControl("http://dev.catalog.trendyol.com/api/boutiquenewsletter");
        System.out.println("-----------------------------------------------");
        System.out.println("Dev2 ortamında label sayısı kontrolü");
        System.out.println("");
        JSONLabelCountControl("http://dev2.catalog.trendyol.com/api/boutiquenewsletter");

    }

    public ArrayList<Boutique> ParseJSONtoArrayList(String URL){


        ArrayList<Boutique> listBoutique=null;

        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application / json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : "
                        +conn.getResponseCode());
            }

            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();

            scan.close();

            listBoutique=new ArrayList<Boutique>();

            List<Integer> listId = JsonPath.read(entireResponse, "$.Items.[*].id");
            List<String> listName = JsonPath.read(entireResponse, "$.Items.[*].name");
            List<String> listCloseDate= JsonPath.read(entireResponse, "$.Items.[*].CloseDate");
            List<String> listDiscount = JsonPath.read(entireResponse, "$.Items.[*].Discount");
            List<String> listTags = JsonPath.read(entireResponse, "$.Items.[*].tags");
            List<String> listOrderFemale = JsonPath.read(entireResponse, "$.Items.[*].Order.female");
            List<String> listOrderMale = JsonPath.read(entireResponse, "$.Items.[*].Order.male");
            List<String> listSmallImageMale = JsonPath.read(entireResponse, "$.Items.[*].SmallImageURL.male");
            List<String> listSmallImageFemale = JsonPath.read(entireResponse, "$.Items.[*].SmallImageURL.female");
            List<String> listBigImageURLMale = JsonPath.read(entireResponse, "$.Items.[*].BigImageURL.male");
            List<String> listBigImageURLFemale = JsonPath.read(entireResponse, "$.Items.[*].BigImageURL.female");
            List<String> listLinkUrlMale = JsonPath.read(entireResponse, "$.Items.[*].LinkUrl.male");
            List<String> listLinkUrlFemale = JsonPath.read(entireResponse, "$.Items.[*].LinkUrl.female");
            List<String> listGender = JsonPath.read(entireResponse, "$.Items.[*].Gender");
            List<String> listBrands = JsonPath.read(entireResponse, "$.Items.[*].Brands");
            List<String> listCategories = JsonPath.read(entireResponse, "$.Items.[*].Categories");
            List<String> listPrice = JsonPath.read(entireResponse, "$.Items.[*].Price");

            for (int i=0;i<listId.size();i++) {

                Boutique b=new Boutique();

                b.setId(listId.get(i));
                b.setName(listName.get(i));
                b.setCloseDate(listCloseDate.get(i));
                b.setDiscount(listDiscount.get(i));
                b.setTags(listTags.get(i));
                b.setOrderFemale(listOrderFemale.get(i));
                b.setOrderMale(listOrderMale.get(i));
                b.setBigImageUrlFemale(listBigImageURLFemale.get(i));
                b.setBigImageUrlMale(listBigImageURLMale.get(i));
                b.setSmallImageUrlFemale(listSmallImageFemale.get(i));
                b.setSmallImageUrlMale(listSmallImageMale.get(i));
                b.setLinkUrlFemale(listLinkUrlFemale.get(i));
                b.setLinkUrlMale(listLinkUrlMale.get(i));
                b.setGender(listGender.get(i));
                b.setBrands(listBrands.get(i));
                b.setCategories(listCategories.get(i));
                b.setPrice(listPrice.get(i));

                listBoutique.add(b);
            }



        } catch (Exception e) {
            e.printStackTrace();

        }

        return listBoutique;
    }

    public void EmptyLabelControl(ArrayList<Boutique> lstBoutique){
        int countName=0,countCloseDate=0,countGender=0,countBrands=0,countBigMale=0,countBigFemale=0,countSmallMale=0,
                countSmallFemale=0,countLinkMale=0,countLinkFemale=0,countCategories=0,countDiscount=0,countPrice=0,
                countTags=0,countOrderMale=0,countOrderFemale=0;

        for(int i=0;i<lstBoutique.size();i++){

            if(lstBoutique.get(i).getName().equals("")){

                countName++;

            }

            if(lstBoutique.get(i).getCloseDate().equals("")){

                countCloseDate++;

            }

            if(lstBoutique.get(i).getDiscount().equals("")){

                countDiscount++;

            }

            if(lstBoutique.get(i).getTags().equals("")){

                countTags++;

            }
            if(lstBoutique.get(i).getOrderFemale().equals("")){

                countOrderFemale++;

            }
            if(lstBoutique.get(i).getOrderMale().equals("")){

                countOrderMale++;

            }
            if(lstBoutique.get(i).getSmallImageUrlFemale().equals("")){

                countSmallFemale++;

            }
            if(lstBoutique.get(i).getSmallImageUrlMale().equals("")){

                countSmallMale++;

            }
            if(lstBoutique.get(i).getBigImageUrlFemale().equals("")){

                countBigFemale++;

            }
            if(lstBoutique.get(i).getBigImageUrlMale().equals("")){

                countBigMale++;

            }
            if(lstBoutique.get(i).getLinkUrlFemale().equals("")){

                countLinkFemale++;

            }
            if(lstBoutique.get(i).getLinkUrlMale().equals("")){

                countLinkMale++;

            }
            if(lstBoutique.get(i).getGender().equals("")){

                countGender++;

            }
            if(lstBoutique.get(i).getBrands().equals("")){

                countBrands++;

            }
            if(lstBoutique.get(i).getCategories().equals("")){

                countCategories++;

            }
            if(lstBoutique.get(i).getPrice().equals("")){

                countPrice++;

            }
        }

        System.out.println("Name boş etiket sayısı:"+countName);
        System.out.println("CloseDate boş etiket sayısı:"+countCloseDate);
        System.out.println("Discount boş etiket sayısı:"+countDiscount);
        System.out.println("Tags boş etiket sayısı:"+countTags);
        System.out.println("OrderFemale boş etiket sayısı:"+countOrderFemale);
        System.out.println("OrderMale boş etiket sayısı:"+countOrderMale);
        System.out.println("SmallURLFemale boş etiket sayısı:"+countSmallFemale);
        System.out.println("SmallURLMale boş etiket sayısı:"+countSmallMale);
        System.out.println("BigURLFemale boş etiket sayısı:"+countBigFemale);
        System.out.println("BigURLMale boş etiket sayısı:"+countBigMale);
        System.out.println("LinkUrlFemale boş etiket sayısı:"+countLinkFemale);
        System.out.println("LinkUrlMale boş etiket sayısı:"+countLinkMale);
        System.out.println("Gender boş etiket sayısı:"+countGender);
        System.out.println("Brands boş etiket sayısı:"+countBrands);
        System.out.println("Categories boş etiket sayısı:"+countCategories);
        System.out.println("Price boş etiket sayısı:"+countPrice);


    }

    public void JSONLabelCountControl(String URL){

        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application / json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : "
                        +conn.getResponseCode());
            }

            Scanner scan = new Scanner(url.openStream());
            String entireResponse = new String();
            while (scan.hasNext())
                entireResponse += scan.nextLine();

            System.out.println("Response : "+entireResponse);

            scan.close();

            List<Integer> listId = JsonPath.read(entireResponse, "$.Items.[*].id");
            List<String> listName = JsonPath.read(entireResponse, "$.Items.[*].name");
            List<String> listCloseDate= JsonPath.read(entireResponse, "$.Items.[*].CloseDate");
            List<String> listDiscount = JsonPath.read(entireResponse, "$.Items.[*].Discount");
            List<String> listTags = JsonPath.read(entireResponse, "$.Items.[*].tags");
            List<String> listOrderFemale = JsonPath.read(entireResponse, "$.Items.[*].Order.female");
            List<String> listOrderMale = JsonPath.read(entireResponse, "$.Items.[*].Order.male");
            List<String> listSmallImageMale = JsonPath.read(entireResponse, "$.Items.[*].SmallImageURL.male");
            List<String> listSmallImageFemale = JsonPath.read(entireResponse, "$.Items.[*].SmallImageURL.female");
            List<String> listBigImageURLMale = JsonPath.read(entireResponse, "$.Items.[*].BigImageURL.male");
            List<String> listBigImageURLFemale = JsonPath.read(entireResponse, "$.Items.[*].BigImageURL.female");
            List<String> listLinkUrlMale = JsonPath.read(entireResponse, "$.Items.[*].LinkUrl.male");
            List<String> listLinkUrlFemale = JsonPath.read(entireResponse, "$.Items.[*].LinkUrl.female");
            List<String> listGender = JsonPath.read(entireResponse, "$.Items.[*].Gender");
            List<String> listBrands = JsonPath.read(entireResponse, "$.Items.[*].Brands");
            List<String> listCategories = JsonPath.read(entireResponse, "$.Items.[*].Categories");
            List<String> listPrice = JsonPath.read(entireResponse, "$.Items.[*].Price");



            if(listName.size()<listId.size()){
                System.out.println(listId.size()-listName.size()+" adet Name etiketi eksik");
            }
            else{
                System.out.println(" Name etiketi ve Id etiketi sayısı aynı");
            }
            if(listCloseDate.size()<listId.size()){
                System.out.println(listId.size()-listCloseDate.size()+" adet CloseDate etiketi eksik");
            }
            else{
                System.out.println(" CloseDate etiketi ve Id etiketi sayısı aynı");
            }
            if(listDiscount.size()<listId.size()){
                System.out.println(listId.size()-listDiscount.size()+" adet Discount etiketi eksik");
            }
            else{
                System.out.println(" Discount etiketi ve Id etiketi sayısı aynı");
            }
            if(listTags.size()<listId.size()){
                System.out.println(listId.size()-listTags.size()+" adet Tags etiketi eksik");
            }
            else{
                System.out.println(" Tags etiketi ve Id etiketi sayısı aynı");
            }
            if(listOrderFemale.size()<listId.size()){
                System.out.println(listId.size()-listOrderFemale.size()+" adet OrderFemale etiketi eksik");
            }
            else{
                System.out.println(" OrderFemale etiketi ve Id etiketi sayısı aynı");
            }
            if(listOrderMale.size()<listId.size()){
                System.out.println(listId.size()-listOrderMale.size()+" adet OrderMale etiketi eksik");
            }
            else{
                System.out.println(" OrderMale etiketi ve Id etiketi sayısı aynı");
            }
            if(listSmallImageFemale.size()<listId.size()){
                System.out.println(listId.size()-listSmallImageFemale.size()+" adet SmallImageUrlFemale etiketi eksik");
            }
            else{
                System.out.println(" SmallImageUrlFemale etiketi ve Id etiketi sayısı aynı");
            }
            if(listSmallImageMale.size()<listId.size()){
                System.out.println(listId.size()-listSmallImageMale.size()+" adet SmallImageUrlMale etiketi eksik");
            }
            else{
                System.out.println(" SmallImageUrlMale etiketi ve Id etiketi sayısı aynı");
            }
            if(listBigImageURLFemale.size()<listId.size()){
                System.out.println(listId.size()-listBigImageURLFemale.size()+" adet BigImageUrlFemale etiketi eksik");
            }
            else{
                System.out.println(" BigImageUrlFemale etiketi ve Id etiketi sayısı aynı");
            }
            if(listBigImageURLMale.size()<listId.size()){
                System.out.println(listId.size()-listBigImageURLMale.size()+" adet BigImageUrlMale etiketi eksik");
            }
            else{
                System.out.println(" BigImageUrlMale etiketi ve Id etiketi sayısı aynı");
            }
            if(listLinkUrlFemale.size()<listId.size()){
                System.out.println(listId.size()-listLinkUrlFemale.size()+" adet LinkUrlFemale etiketi eksik");
            }
            else{
                System.out.println(" LinkUrlFemale etiketi ve Id etiketi sayısı aynı");
            }
            if(listLinkUrlMale.size()<listId.size()){
                System.out.println(listId.size()-listLinkUrlMale.size()+" adet LinkUrlMale etiketi eksik");
            }
            else{
                System.out.println(" LinkUrlMale etiketi ve Id etiketi sayısı aynı");
            }
            if(listGender.size()<listId.size()){
                System.out.println(listId.size()-listGender.size()+" adet Gender etiketi eksik");
            }
            else{
                System.out.println(" Gender etiketi ve Id etiketi sayısı aynı");
            }
            if(listBrands.size()<listId.size()){
                System.out.println(listId.size()-listBrands.size()+" adet Brands etiketi eksik");
            }
            else{
                System.out.println(" Brands etiketi ve Id etiketi sayısı aynı");
            }
            if(listCategories.size()<listId.size()){
                System.out.println(listId.size()-listCategories.size()+" adet Categories etiketi eksik");
            }
            else{
                System.out.println(" Categories etiketi ve Id etiketi sayısı aynı");
            }
            if(listPrice.size()<listId.size()){
                System.out.println(listId.size()-listPrice.size()+" adet Price etiketi eksik");
            }
            else{
                System.out.println(" Price etiketi ve Id etiketi sayısı aynı");
            }


        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void MatchingLists(int count, String etiket){


        if (count == 0) {

            System.out.println("İki ortamda da "+etiket+ "etiketine'inde ait veriler aynı");;

        } else {

            System.out.println("İki ortamda "+etiket+" etiketine ait aynı olmayan veri sayısı:"+count);

        }

    }


}
