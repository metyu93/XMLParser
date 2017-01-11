import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import Entity.Product;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Random;

public class productApiTest {

    //Item count kontrolü
    @Test
    public void UniqueCountEqualTest() {

        int countUrunIdDev = 0;
        int countUrunIdDev2 = 0;

        ArrayList<Product> lstUrunId1 = ParseXMLtoArrayList("http://dev.catalog.trendyol.com/products/");
        ArrayList<Product> lstUrunId2 = ParseXMLtoArrayList("http://dev2.catalog.trendyol.com/products/");


        for (int i = 0; i < lstUrunId1.size(); i++) {
            countUrunIdDev++;
        }
        for (int i = 0; i < lstUrunId2.size(); i++) {
            countUrunIdDev2++;
        }

        System.out.println("urun_id count dev:" + countUrunIdDev);
        System.out.println("urun_id count dev2:" + countUrunIdDev2);

        if (lstUrunId1.size() == lstUrunId2.size()) {
            System.out.println("İki ortamda da urunid sayıları aynı");
        } else {
            System.out.println("İki ortamdaki urunid sayıları eşit değil!");
        }
    }

    //Eşitlik kontrolü
    @Test
    public void DataEgualAPITest() {

        int temp = 0;
        int max = 0;
        int countPrice = 0, countId = 0, countDescription = 0, countBoutiqueId = 0,
                countProduct_type = 0, countBrand = 0, countScore = 0, countTitle = 0, countLink = 0, countImageLink = 0, countThumbLink = 0,
                countZoomLink = 0, countCondition = 0, countAvailability = 0, countRetailPrice = 0, countMpn = 0, countExpiationDate = 0,
                countAdwordesRedirect = 0, countAdwordsGrouping = 0, countCustom_label0 = 0, countCustom_label1 = 0, countCustom_label2 = 0,
                countCustom_label3 = 0, countGender = 0,countSalesPrice = 0, countMarketPrice = 0, countVGender = 0,
                countVBrand = 0, countVCategory = 0, countVPrice = 0, countHizliTeslimat = 0, countDeepLink = 0, countMobile = 0, countPcode = 0;

        //Dev1
        ArrayList<Product> listDev=ParseXMLtoArrayList("http://dev.catalog.trendyol.com/products/");


        //Dev2
        ArrayList<Product> listDev2=ParseXMLtoArrayList("http://dev2.catalog.trendyol.com/products/");

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


        for (int i = 0 ; i < dizi.length ; i++) {

            for (int j = 0 ; j < max ; j++) {

                if (listDev.get(dizi[i]).getUrun_id().equals(listDev2.get(j).getUrun_id())) {


                    if (!listDev.get(dizi[i]).getId().equals(listDev2.get(j).getId())) {
                        countId++;
                    }

                    if (!listDev.get(dizi[i]).getDescription().equals(listDev2.get(j).getDescription())) {
                        countDescription++;
                    }

                    if (!listDev.get(dizi[i]).getBoutiqueId().equals(listDev2.get(j).getBoutiqueId())) {
                        countBoutiqueId++;
                    }

                    if (!listDev.get(dizi[i]).getPrice().equals(listDev2.get(j).getPrice())) {
                        countPrice++;
                    }

                    if (!listDev.get(dizi[i]).getProduct_type().equals(listDev2.get(j).getProduct_type())) {
                        countProduct_type++;
                    }

                    if (!listDev.get(dizi[i]).getBrand().equals(listDev2.get(j).getBrand())) {
                        countBrand++;
                    }

                    if (!listDev.get(dizi[i]).getScore().equals(listDev2.get(j).getScore())) {
                        countScore++;
                    }

                    if (!listDev.get(dizi[i]).getTitle().equals(listDev2.get(j).getTitle())) {
                        countTitle++;
                    }

                    if (!listDev.get(dizi[i]).getLink().equals(listDev2.get(j).getLink())) {
                        countLink++;
                    }

                    if (!listDev.get(dizi[i]).getImageLink().equals(listDev2.get(j).getImageLink())) {
                        countImageLink++;
                    }

                    if (!listDev.get(dizi[i]).getThumb_image_link().equals(listDev2.get(j).getThumb_image_link())) {
                        countThumbLink++;
                    }

                    if (!listDev.get(dizi[i]).getZoom_image_link().equals(listDev2.get(j).getZoom_image_link())) {
                        countZoomLink++;
                    }

                    if (!listDev.get(dizi[i]).getCondition().equals(listDev2.get(j).getCondition())) {
                        countCondition++;
                    }

                    if (!listDev.get(dizi[i]).getAvailability().equals(listDev2.get(j).getAvailability())) {
                        countAvailability++;
                    }

                    if (!listDev.get(dizi[i]).getRetail_price().equals(listDev2.get(j).getRetail_price())) {
                        countRetailPrice++;
                    }

                    if (!listDev.get(dizi[i]).getMpn().equals(listDev2.get(j).getMpn())) {
                        countMpn++;
                    }

                    if (!listDev.get(dizi[i]).getAdwords_redirect().equals(listDev2.get(j).getAdwords_redirect())) {
                        countAdwordesRedirect++;
                    }

                    if (!listDev.get(dizi[i]).getAdwords_grouping().equals(listDev2.get(j).getAdwords_grouping())) {
                        countAdwordsGrouping++;
                    }

                    if (!listDev.get(dizi[i]).getCustom_label_0().equals(listDev2.get(j).getCustom_label_0())) {
                        countCustom_label0++;
                    }

                    if (!listDev.get(dizi[i]).getCustom_label_1().equals(listDev.get(j).getCustom_label_1())) {
                        countCustom_label1++;
                    }

                    if (!listDev.get(dizi[i]).getCustom_label_2().equals(listDev2.get(j).getCustom_label_2())) {
                        countCustom_label2++;
                    }

                    if (!listDev.get(dizi[i]).getCustom_label_3().equals(listDev2.get(j).getCustom_label_3())) {
                        countCustom_label3++;
                    }

                    if (!listDev.get(dizi[i]).getGender().equals(listDev2.get(j).getGender())) {
                        countGender++;
                    }


                    if (!listDev.get(dizi[i]).getSalesPrice().equals(listDev2.get(j).getSalesPrice())) {
                        countSalesPrice++;
                    }

                    if (!listDev.get(dizi[i]).getMarketPrice().equals(listDev2.get(j).getMarketPrice())) {
                        countMarketPrice++;
                    }

                    if (!listDev.get(dizi[i]).getvGender().equals(listDev2.get(j).getvGender())) {
                        countVGender++;
                    }

                    if (!listDev.get(dizi[i]).getvBrand().equals(listDev2.get(j).getvBrand())) {
                        countVBrand++;
                    }

                    if (!listDev.get(dizi[i]).getvCategory().equals(listDev2.get(j).getvCategory())) {
                        countVCategory++;
                    }

                    if (!listDev.get(dizi[i]).getvPrice().equals(listDev2.get(j).getvPrice())) {
                        countVPrice++;
                    }

                    if (!listDev.get(dizi[i]).getHizli_teslimat().equals(listDev2.get(j).getHizli_teslimat())) {
                        countHizliTeslimat++;
                    }

                    if (!listDev.get(dizi[i]).getHizli_teslimat().equals(listDev2.get(j).getHizli_teslimat())) {
                        countHizliTeslimat++;
                    }

                    if (!listDev.get(dizi[i]).getDeepLink().equals(listDev2.get(j).getDeepLink())) {
                        countDeepLink++;
                    }

                    if (!listDev.get(dizi[i]).getMobile_android_app_link().equals(listDev2.get(j).getMobile_android_app_link())) {
                        countMobile++;
                    }

                    if (!listDev.get(dizi[i]).getPcode().equals(listDev2.get(j).getPcode())) {
                        countPcode++;
                    }
                }
            }

        }

        System.out.println("Bu test ile ortamda yer alan aynı Tag'lerdeki veriler karşılaştırılmaktadır!");
        System.out.println("");


        MatchingLists(countId,"g:id");
        MatchingLists(countDescription,"description");
        MatchingLists(countBoutiqueId,"g:g:boutiqueId");
        MatchingLists(countPrice,"g:price");
        MatchingLists(countProduct_type,"g:product_type");
        MatchingLists(countBrand,"g:brand");
        MatchingLists(countScore,"g:score");
        MatchingLists(countTitle,"title");
        MatchingLists(countLink,"link");
        MatchingLists(countImageLink,"g:image_link");
        MatchingLists(countThumbLink,"thumb_image_link");
        MatchingLists(countZoomLink,"zoom;_image_link");
        MatchingLists(countCondition,"g:condition");
        MatchingLists(countAvailability,"g:availability");
        MatchingLists(countRetailPrice,"retail_price");
        MatchingLists(countMpn,"g:mpn");
        MatchingLists(countExpiationDate,"g:expiration_date");
        MatchingLists(countAdwordesRedirect,"g:adwords_redirect");
        MatchingLists(countAdwordsGrouping,"g:adwords_grouping");
        MatchingLists(countCustom_label0,"g:custom_label_0");
        MatchingLists(countCustom_label1,"g:custom_label_1");
        MatchingLists(countCustom_label2,"g:custom_label_2");
        MatchingLists(countCustom_label3,"g:custom_label_3");
        MatchingLists(countGender,"g:gender");
        MatchingLists(countSalesPrice,"SalesPrice");
        MatchingLists(countMarketPrice,"MarketPrice");
        MatchingLists(countVGender,"VGender");
        MatchingLists(countVBrand,"VBrand");
        MatchingLists(countGender,"VCategory");
        MatchingLists(countVPrice,"VPrice");
        MatchingLists(countHizliTeslimat,"g:hizli_teslimat");
        MatchingLists(countDeepLink,"DeepLink");
        MatchingLists(countMobile,"g:mobile_android_app_link");
        MatchingLists(countPcode,"g:pcode");


    }

    //Boşluk kontrolü
    @Test
    public void TagEmptyTest() {


        ArrayList<Product> lstDev1 = ParseXMLtoArrayList("http://dev.catalog.trendyol.com/products/");
        ArrayList<Product> lstDev2 = ParseXMLtoArrayList("http://dev2.catalog.trendyol.com/products/");

//Dev Empty Control

        System.out.println("Dev Empty Control");
        System.out.println("");


        TagEmptyControl(lstDev1);
//Dev2 Empty Control

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Dev2 Empty Control");
        System.out.println("");

        TagEmptyControl(lstDev2);

    }

    public ArrayList<Product> ParseXMLtoArrayList(String URL) {
        ArrayList<Product> listProduct = null;
        int itemCount = 0;

        try {

            listProduct = new ArrayList<Product>();

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(URL);

            doc.getDocumentElement().normalize();

            NodeList listOfItems = doc.getElementsByTagName("item");
            itemCount = listOfItems.getLength();

            for (int i = 0; i < listOfItems.getLength(); i++) {

                Node node = listOfItems.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Product product=new Product();
                    Element firstElement = (Element)node;

                    product.setId(XMLParse(firstElement,"g:id"));
                    product.setUrun_id(XMLParse(firstElement,"g:urunid"));
                    product.setDescription(XMLParse(firstElement,"description"));
                    product.setBoutiqueId(XMLParse(firstElement,"g:boutiqueId"));
                    product.setPrice(XMLParse(firstElement,"g:price"));
                    product.setProduct_type(XMLParse(firstElement,"g:product_type"));
                    product.setBrand(XMLParse(firstElement,"g:brand"));
                    product.setScore(XMLParse(firstElement,"g:score"));
                    product.setTitle(XMLParse(firstElement,"title"));
                    product.setLink(XMLParse(firstElement,"link"));
                    product.setImageLink(XMLParse(firstElement,"g:image_link"));
                    product.setThumb_image_link(XMLParse(firstElement,"thumb_image_link"));
                    product.setZoom_image_link(XMLParse(firstElement,"zoom_image_link"));
                    product.setCondition(XMLParse(firstElement,"g:condition"));
                    product.setAvailability(XMLParse(firstElement,"g:availability"));
                    product.setRetail_price(XMLParse(firstElement,"retail_price"));
                    product.setMpn(XMLParse(firstElement,"g:mpn"));
                    product.setExpiration_date(XMLParse(firstElement,"g:expiration_date"));
                    product.setAdwords_redirect(XMLParse(firstElement,"g:adwords_redirect"));
                    product.setAdwords_grouping(XMLParse(firstElement,"g:adwords_grouping"));
                    product.setCustom_label_0(XMLParse(firstElement,"g:custom_label_0"));
                    product.setCustom_label_1(XMLParse(firstElement,"g:custom_label_1"));
                    product.setCustom_label_2(XMLParse(firstElement,"g:custom_label_2"));
                    product.setCustom_label_3(XMLParse(firstElement,"g:custom_label_3"));
                    product.setGender(XMLParse(firstElement,"g:gender"));
                    product.setSalesPrice(XMLParse(firstElement,"SalePrice"));
                    product.setMarketPrice(XMLParse(firstElement,"MarketPrice"));
                    product.setvGender(XMLParse(firstElement,"VGender"));
                    product.setvBrand(XMLParse(firstElement,"VBrand"));
                    product.setvCategory(XMLParse(firstElement,"VCategory"));
                    product.setvPrice(XMLParse(firstElement,"VPrice"));
                    product.setHizli_teslimat(XMLParse(firstElement,"g:hizli_teslimat"));
                    product.setDeepLink(XMLParse(firstElement,"DeepLink"));
                    product.setMobile_android_app_link(XMLParse(firstElement,"g:mobile_android_app_link"));
                    product.setPcode(XMLParse(firstElement,"g:pcode"));

                    listProduct.add(product);

                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        return listProduct;

    }

    public ArrayList<Product> ParseProductCategory(String URL){

        ArrayList<Product> listProduct = null;
        int itemCount = 0;

        try {

            listProduct = new ArrayList<Product>();

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(URL);

            doc.getDocumentElement().normalize();

            NodeList listOfItems = doc.getElementsByTagName("item");
            itemCount = listOfItems.getLength();

            for (int i = 0; i < listOfItems.getLength(); i++) {

                Node node = listOfItems.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Product product=new Product();
                    Element firstElement = (Element)node;

                    product.setUrun_id(XMLParse(firstElement,"g:urunid"));
                    product.setGoogle_product_category(XMLParse(firstElement,"g:google_product_category"));


                    listProduct.add(product);

                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        return listProduct;

    }

    public void MatchingLists(int count, String tag){


        if (count == 0) {

            System.out.println("İki ortamda da "+tag+ "tag'inde ait veriler aynı");;

        } else {

            System.out.println("İki ortamda "+tag+" tag'ine ait aynı olmayan veri sayısı:"+ count);

        }

    }

    public void TagEmptyControl(ArrayList<Product> lstDev1){


        int countPrice = 0, countId = 0, countUrun_id = 0, countDescription = 0, countBoutiqueId = 0,
                countProduct_type = 0, countBrand = 0, countScore = 0, countTitle = 0, countLink = 0, countImageLink = 0, countThumbLink = 0,
                countZoomLink = 0, countCondition = 0, countAvailability = 0, countRetailPrice = 0, countMpn = 0, countExpiationDate = 0,
                countAdwordesRedirect = 0, countAdwordsGrouping = 0, countCustom_label0 = 0, countCustom_label1 = 0, countCustom_label2 = 0,
                countCustom_label3 = 0, countGender = 0, countAdwordsQueryparam = 0, countSalesPrice = 0, countMarketPrice = 0, countVGender = 0,
                countVBrand = 0, countVCategory = 0, countVPrice = 0, countHizliTeslimat = 0, countDeepLink = 0, countMobile = 0, countPcode = 0;




        for (int i = 0; i < lstDev1.size(); i++) {

            if (lstDev1.get(i).getId().equals("")) {
                countId++;
            }

            if (lstDev1.get(i).getUrun_id().equals("")) {
                countUrun_id++;
            }

            if (lstDev1.get(i).getDescription().equals("")) {
                countDescription++;
            }

            if (lstDev1.get(i).getBoutiqueId().equals("")) {
                countBoutiqueId++;
            }

            if (lstDev1.get(i).getPrice().equals("")) {
                countPrice++;
            }

            if (lstDev1.get(i).getProduct_type().equals("")) {
                countProduct_type++;
            }

            if (lstDev1.get(i).getBrand().equals("")) {
                countBrand++;
            }

            if (lstDev1.get(i).getTitle().equals("")) {
                countTitle++;
            }
            if (lstDev1.get(i).getLink().equals("")) {
                countLink++;
            }
            if (lstDev1.get(i).getImageLink().equals("")) {
                countImageLink++;
            }
            if (lstDev1.get(i).getThumb_image_link().equals("")) {
                countThumbLink++;
            }

            if (lstDev1.get(i).getZoom_image_link().equals("")) {
                countZoomLink++;
            }

            if (lstDev1.get(i).getCondition().equals("")) {
                countCondition++;
            }

            if (lstDev1.get(i).getAvailability().equals("")) {
                countThumbLink++;
            }

            if (lstDev1.get(i).getRetail_price().equals("")) {
                countRetailPrice++;
            }

            if (lstDev1.get(i).getMpn().equals("")) {
                countMpn++;
            }

            if (lstDev1.get(i).getExpiration_date().equals("")) {
                countExpiationDate++;
            }

            if (lstDev1.get(i).getAdwords_redirect().equals("")) {
                countAdwordesRedirect++;
            }

            if (lstDev1.get(i).getAdwords_grouping().equals("")) {
                countAdwordsGrouping++;
            }

            if (lstDev1.get(i).getCustom_label_0().equals("")) {
                countCustom_label0++;
            }

            if (lstDev1.get(i).getCustom_label_1().equals("")) {
                countCustom_label1++;
            }

            if (lstDev1.get(i).getCustom_label_2().equals("")) {
                countCustom_label2++;
            }

            if (lstDev1.get(i).getCustom_label_3().equals("")) {
                countCustom_label3++;
            }

            if (lstDev1.get(i).getGender().equals("")) {
                countGender++;
            }


            if (lstDev1.get(i).getSalesPrice().equals("")) {
                countSalesPrice++;
            }

            if (lstDev1.get(i).getMarketPrice().equals("")) {
                countMarketPrice++;
            }

            if (lstDev1.get(i).getvGender().equals("")) {
                countVGender++;
            }

            if (lstDev1.get(i).getvBrand().equals("")) {
                countVBrand++;
            }

            if (lstDev1.get(i).getvCategory().equals("")) {
                countVCategory++;
            }

            if (lstDev1.get(i).getvPrice().equals("")) {
                countVPrice++;
            }

            if (lstDev1.get(i).getHizli_teslimat().equals("")) {
                countHizliTeslimat++;
            }

            if (lstDev1.get(i).getDeepLink().equals("")) {
                countDeepLink++;
            }

            if (lstDev1.get(i).getMobile_android_app_link().equals("")) {
                countMobile++;
            }

            if (lstDev1.get(i).getPcode().equals("")) {
                countPcode++;
            }

        }

        System.out.println("Dev test ortamında veri olmayan g:id tag sayısı:" + countId);
        System.out.println("Dev test ortamında veri olmayan g:urunid tag sayısı:" + countUrun_id);
        System.out.println("Dev test ortamında veri olmayan g:description tag sayısı:" + countDescription);
        System.out.println("Dev test ortamında veri olmayan g:boutiqueId tag sayısı:" + countBoutiqueId);
        System.out.println("Dev test ortamında veri olmayan g:price tag sayısı:" + countPrice);
        System.out.println("Dev test ortamında veri olmayan g:product_type tag sayısı:" + countProduct_type);
        System.out.println("Dev test ortamında veri olmayan g:brand tag sayısı:" + countBrand);
        System.out.println("Dev test ortamında veri olmayan g:score tag sayısı:" + countScore);
        System.out.println("Dev test ortamında veri olmayan title tag sayısı:" + countTitle);
        System.out.println("Dev test ortamında veri olmayan link tag sayısı:" + countLink);
        System.out.println("Dev test ortamında veri olmayan g:image_link tag sayısı:" + countImageLink);
        System.out.println("Dev test ortamında veri olmayan thumb_image_link tag sayısı:" + countThumbLink);
        System.out.println("Dev test ortamında veri olmayan zoom_image_link tag sayısı:" + countZoomLink);
        System.out.println("Dev test ortamında veri olmayan g:condition tag sayısı:" + countCondition);
        System.out.println("Dev test ortamında veri olmayan g:availability tag sayısı:" + countAvailability);
        System.out.println("Dev test ortamında veri olmayan retail_price tag sayısı:" + countRetailPrice);
        System.out.println("Dev test ortamında veri olmayan g:mpn tag sayısı:" + countMpn);
        System.out.println("Dev test ortamında veri olmayan g:expiration_date tag sayısı:" + countExpiationDate);
        System.out.println("Dev test ortamında veri olmayan g:adwords_redirect tag sayısı:" + countAdwordesRedirect);
        System.out.println("Dev test ortamında veri olmayan g:adwords grouping tag sayısı:" + countAdwordsGrouping);
        System.out.println("Dev test ortamında veri olmayan g:custom_label_0 tag sayısı:" + countCustom_label0);
        System.out.println("Dev test ortamında veri olmayan g:custom_label_1 tag sayısı:" + countCustom_label1);
        System.out.println("Dev test ortamında veri olmayan g:custom_label_2 tag sayısı:" + countCustom_label2);
        System.out.println("Dev test ortamında veri olmayan g:custom_label_3 tag sayısı:" + countCustom_label3);
        System.out.println("Dev test ortamında veri olmayan g:gender tag sayısı:" + countGender);
        System.out.println("Dev test ortamında veri olmayan g:adwords_queryparam tag sayısı:" + countAdwordsQueryparam);
        System.out.println("Dev test ortamında veri olmayan SalesPrice tag sayısı:" + countSalesPrice);
        System.out.println("Dev test ortamında veri olmayan MarketPrice tag sayısı:" + countMarketPrice);
        System.out.println("Dev test ortamında veri olmayan VGender tag sayısı:" + countVGender);
        System.out.println("Dev test ortamında veri olmayan VBrand tag sayısı:" + countVBrand);
        System.out.println("Dev test ortamında veri olmayan VCategory tag sayısı:" + countVCategory);
        System.out.println("Dev test ortamında veri olmayan VPrice tag sayısı:" + countVPrice);
        System.out.println("Dev test ortamında veri olmayan g:hizli_teslimat tag sayısı:" + countHizliTeslimat);
        System.out.println("Dev test ortamında veri olmayan DeepLink tag sayısı:" + countDeepLink);
        System.out.println("Dev test ortamında veri olmayan g:mobile_android_app_link tag sayısı:" + countMobile);
        System.out.println("Dev test ortamında veri olmayan g:pcode tag sayısı:" + countPcode);






    }

    public String XMLParse(Element e,String s){

        NodeList firstNameList = e.getElementsByTagName(s);
        Element firstNameElement = (Element)firstNameList.item(0);

        NodeList textFNList = firstNameElement.getChildNodes();

        String tag=((Node)textFNList.item(0)).getNodeValue().trim();


        return  tag;

    }


}
