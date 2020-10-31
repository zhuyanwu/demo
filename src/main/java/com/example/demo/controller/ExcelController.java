package com.example.demo.controller;

import com.example.demo.util.ExcelUtil;
import com.example.demo.util.POIUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
public class ExcelController {


    /**
     * 生成excel
     * @throws Exception
     */
    @GetMapping("/create")
    public void create() throws Exception{
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("sheet1");
        HSSFRow row = sheet1.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("导出");
        FileOutputStream fos = new FileOutputStream("D:\\export.xls");
        wb.write(fos);
        fos.flush();
    }

    /**
     * 导出excel
     */
    @GetMapping("/export")
    public void export (HttpServletRequest request, HttpServletResponse response){
        //封装表头
        String fileName = "zhuyanwu.xls";
        String[] title = {"序号","问题","问题类型","答案","分类","女神"};
        String sheetName = "富婆通讯录";

        String[][] content = new String[1][6];
        content[0][0] ="1";
        content[0][1] ="龙金凤";
        content[0][2] ="陈萍";
        content[0][3] ="钟丹";
        content[0][4] ="陈佩";
        content[0][5] ="陈琳";
        HSSFWorkbook workbook = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
        try {
            fileName = new String(fileName.getBytes(),"UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition","attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 导入
     * @param file
     */
    @PostMapping("/upload")
    public List<String[]> upload(@RequestParam("file") MultipartFile file){

        try {
            List<String[]> strings = POIUtils.readExcel(file);
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        
    }

}
