package test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * User: DEDE
 * Date: 15-6-4
 * Time: 下午4:49
 * 说明：
 */
public class PageTest {
    public static void main(String[] args) throws Exception{
        Scanner cin=new Scanner(System.in);
        System.out.println("请输入文件目录路径：");
        String dirName=cin.nextLine();
        //File dir = new File("E:\\活动文档\\201506-爱分享模板\\爱分享抢流量html");
        File dir = new File(dirName);
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if(!name.endsWith(".html")){
                    return false;
                }
                return true;

            }
        });
        StringBuffer html = new StringBuffer("");
        html.append("<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"content-type\" content=\"text/html;charset=gbk\"/>\n" +
                "</head>\n" +
                "<body>");
        for(File tmpFile : files){
            String name = URLEncoder.encode(tmpFile.getName(),"UTF-8");

            html.append("<br/><a href='" + name + "' target='_blank' style='font-size:130%'>" + tmpFile.getName() + "</a>");


        }
        html.append("</body>\n" +
                "</html>");
        FileUtils.writeStringToFile(new File(dir,"index.html"),html.toString(),"gbk");
        System.out.println("生成好了，OK~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
