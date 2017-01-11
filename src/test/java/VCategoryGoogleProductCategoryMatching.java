import Entity.Category;
import Entity.Product;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by metin.namli on 2.01.2017.
 */
public class VCategoryGoogleProductCategoryMatching {

    String query="select a.Name,b.GoogleProductCategoryId from dbo.ac_custom_ProductCategory a,dbo.GoogleProductCategory b where a.ProductCategoryId=b.ProductCategoryId";

    @Test
    public void CategoryMatching(){

        ArrayList<Category> listCategory=lstGoogleProductId(query);
        ArrayList<Category> listXMLParse=ParseProductCategory("http://dev.catalog.trendyol.com/products/");

        int same=0;

        for (int i = 0 ; i<listXMLParse.size() ; i++){

            for (int j = 0 ; j<listCategory.size() ; j++) {

                if (listXMLParse.get(i).getGoogle_product_category().equals(listCategory.get(j).getGoogle_product_category()) && listXMLParse.get(i).getvCategoryName().equals(listCategory.get(j).getvCategoryName())) {
                    same++;
                    break;
                }

            }
        }

        System.out.println("Toplamda "+listXMLParse.size()+" veriye ait VCategory ve g:google_product_category taglerinin aynı olduğu item sayısı "+same+" farklı olduğu item sayısı "+(listXMLParse.size()-same));

    }

    public ArrayList<Category> lstGoogleProductId(String query){
        ArrayList<Category> lstGoogleProductIdList=new ArrayList<Category>();
        Connection con=null;

        try{

            con=ConnectDB.getConnection();
            PreparedStatement ps =con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category category=new Category();
                category.setGoogle_product_category(rs.getString("GoogleProductCategoryId"));
                category.setvCategoryName(rs.getString("Name"));
                lstGoogleProductIdList.add(category);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if(con!=null && !con.isClosed())
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return  lstGoogleProductIdList;

    }

    public ArrayList<Category> ParseProductCategory(String URL){

        ArrayList<Category> listCategory = null;
        int itemCount = 0;

        try {

            listCategory = new ArrayList<Category>();

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(URL);

            doc.getDocumentElement().normalize();

            NodeList listOfItems = doc.getElementsByTagName("item");
            itemCount = listOfItems.getLength();

            for (int i = 0; i < listOfItems.getLength(); i++) {

                Node node = listOfItems.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Category category=new Category();
                    Element firstElement = (Element)node;

                    category.setGoogle_product_category(XMLParse(firstElement,"g:google_product_category"));
                    category.setvCategoryName(XMLParse(firstElement,"VCategory"));

                    listCategory.add(category);

                }
            }
        } catch (Exception ex) {
            ex.getStackTrace();
        }

        return listCategory;

    }

    public String XMLParse(Element e,String s){

        NodeList firstNameList = e.getElementsByTagName(s);
        Element firstNameElement = (Element)firstNameList.item(0);

        NodeList textFNList = firstNameElement.getChildNodes();

        String tag=((Node)textFNList.item(0)).getNodeValue().trim();


        return  tag;

    }

}
