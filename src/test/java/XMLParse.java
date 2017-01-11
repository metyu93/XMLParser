import Entity.Product;
import com.jayway.restassured.path.xml.XmlPath;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by metin.namli on 1.01.2017.
 */
public class XMLParse {

    @Test
    public void XMLParser() {

        ArrayList<String> lstProduct=null;
        ArrayList<Product> lst=null;
        try{

            lstProduct=new ArrayList<String>();
            lst=new ArrayList<Product>();


            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("http://dev.catalog.trendyol.com/products/xmlwithcount/10");
            doc.getDocumentElement().normalize();

            NodeList listOfBooks = doc.getElementsByTagName("item");
            int totalBooks = listOfBooks.getLength();
            System.out.println("Total no of item : " + totalBooks);

            for(int i=0; i<listOfBooks.getLength() ; i++) {

                Node firstBookNode = listOfBooks.item(i);
                if(firstBookNode.getNodeType() == Node.ELEMENT_NODE) {

                    Product product=new Product();
                    Element firstElement = (Element)firstBookNode;

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



                   // product.setUrun_id(XMLParse(firstElement,"g:urunid"));
                    lst.add(product);



                }
            }




                System.out.println(lst.size());





        }
        catch(Exception ex){
    }



    }

    public String XMLParse(Element e,String s){

        NodeList firstNameList = e.getElementsByTagName(s);
        Element firstNameElement = (Element)firstNameList.item(0);

        NodeList textFNList = firstNameElement.getChildNodes();

        String tag=((Node)textFNList.item(0)).getNodeValue().trim();


        return  tag;

    }
}
