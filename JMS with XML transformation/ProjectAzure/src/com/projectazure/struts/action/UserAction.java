package com.projectazure.struts.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.projectazure.constants.GenericConstants;
import com.projectazure.hibernate.beans.TourBooking;
import com.projectazure.service.ClerkService;
import com.projectazure.service.TourPackageService;
import com.projectazure.service.UserService;
import com.projectazure.struts.beans.TourAddPackage;
import com.projectazure.struts.beans.TourRequestBean;
@Namespaces(value={@Namespace("/module3/customer/pages"),@Namespace("/module3/clerk/pages"),@Namespace("/")})
public class UserAction extends ActionSupport implements ModelDriven<TourRequestBean>,SessionAware{

	private static final long serialVersionUID = 1L;
	
    UserService userService = new UserService();
	
    TourRequestBean tprequest = new TourRequestBean();

    List<TourBooking> list = new ArrayList<TourBooking>();
    TourPackageService service=new TourPackageService();
    TourPackageAdminAction adminAction=new TourPackageAdminAction();
	int menu;
	private String but;
	





	
	public int getMenu() {
		return menu;
	}
	public void setMenu(int menu) {
		this.menu = menu;
	}



	private Map beanMap;
    
    public int tpBookId;
   
	
	
	
	
	
	
	public Map getBeanMap() {
		return beanMap;
	}
	public void setBeanMap(Map beanMap) {
		this.beanMap = beanMap;
	}
	public int getTpBookId() {
		return tpBookId;
	}
	public void setTpBookId(int tpBookId) {
		this.tpBookId = tpBookId;
	}
	
	public TourRequestBean getModel() {
		// TODO Auto-generated method stub
		return tprequest;
	}
	
	
	
	
	/************************************ Annotations **********************************/
	@Action(value = "bookTourPackage", results = {
			@Result(name = "success", location = "viewbookTourPackage.page" ,type ="tiles"),
			@Result(name = "failure", location = "viewbookTourPackage.page",type ="tiles") })
	public String bookTourPackage() {

		try {
			userService.bookTourPackage(tprequest);
		    return GenericConstants.Success;
		} catch(Exception e) {
			
		}
		

		return GenericConstants.Failure;
	}

	@Action(value = "bookTour", results = {
			@Result(name = "booktour", location = "booktour.page", type ="tiles")
			 })
	public String bookTour() {
		
	   
		return "booktour";
	
	}
  
	@Action(value = "viewBookedPackages", results = {
			@Result(name = "success", location = "ViewUserPackage.page", type ="tiles"),
			@Result(name = "failure", location = "failure.page", type ="tiles")})
public String viewBookedPackages() 
	{
		try {
			
			list = (ArrayList<TourBooking>) userService.viewAllBookedPackages();
			
			beanMap.put("viewList", list);
		
			return "success";
		} catch (Exception e) {
			e.printStackTrace(); 
		}

		return "failure";
    }

	



    public void setSession(Map map) {
		this.beanMap = map;
    }
    
    @Action(value = "viewUpdatePackage", results = {
			@Result(name = "updatePage", location = "Update.page", type ="tiles"),
			@Result(name = "success", location = "viewbookTourPackage.page", type ="tiles"),
			@Result(name = "ViewTourPackage", location = "viewBookTourPackage", type="redirect"),
			@Result(name = "failure", location = "failure.page" ,type="tiles")
			 })
    
    
    public String viewUpdatePackage()
    {
    	if ("Edit Package".equalsIgnoreCase(but))
    	{
    	System.out.println(tpBookId);
        tprequest = userService.viewUpdatePackage(tprequest.getTpBookId());
    	beanMap.put("update", tprequest);
    	return "updatePage";
    	}
    	else if ("Delete Package".equalsIgnoreCase(but)) {
    		userService.deleteBookedPackage(tprequest.getTpBookId());
        	return "success";
    		
		}
    	else {
    		
    		return "viewBookTourPackage";
		}
		
    }
    @Action(value = "updateBookedPackage", results = {
			@Result(name = "success", location = "viewbookTourPackage.page", type ="tiles"),
			@Result(name = "failure", location = "viewbookTourPackage.page", type ="tiles")
			 })
    
    public String updateBookedPackage()
    
    {   
    	try{
    	userService.updateBookedPackage(tprequest,tprequest.getPackageId());
    	
		return "success";
    	}
    	catch(Exception e)
    	{
    		return "failure";
    	}
    }
    @Action(value = "deleteBookedPackage" , results = {
    		 @Result(name = "success", location = "viewbookTourPackage.page", type ="tiles"),
			@Result(name = "failure", location = "viewbookTourPackage.page", type ="tiles")
			 })
    public String deleteBookedPackage()
    {
    	userService.deleteBookedPackage(tpBookId);
    	return "success";
    }
    
    
    
    @Action(value = "reportTourPackage" , results = {
   		 @Result(name = "ViewReport", location = "ViewReport.page", type ="tiles"),
			@Result(name = "failure", location = "failure.page", type ="tiles")
			 })
    
    public String generateReport(){
    	try{
	  System.out.println(getMenu());
	    list=userService.generateReport(getMenu());
    	beanMap.put("ShowList",list);
    	return"ViewReport";
    		
    		
    	}
    	catch (Exception e) {
			// TODO: handle exception
		return "failure";
    	}
} 
    @Action(value = "viewRequest", results = {
			@Result(name = "success", location = "ViewRequest.page", type ="tiles"),
			@Result(name = "failure", location = "failure.page", type ="tiles")})
public String viewRequest() 
	{
		try {
			
			list = (ArrayList<TourBooking>) userService.viewAllBookedPackages();
			
			beanMap.put("viewList", list);
		
			return "success";
		} catch (Exception e) {
			e.printStackTrace(); 
		}

		return "failure";
    }
	public String getBut() {
		return but;
	}
	public void setBut(String but) {
		this.but = but;
	}
    @Action(value = "allocateVehicle", results = {
			@Result(name = "success", location = "allocateVehicle.page", type ="tiles")
			 })
    
   /* public String allocateVehicle()
    {
    	ClerkService clerkService=new ClerkService();
    	clerkService.getVehicles(tprequest.getTpBookId());
    	
    	System.out.println(tpBookId);
    
    	tprequest = userService.viewUpdatePackage(tprequest.getTpBookId());
    	beanMap.put("update", tprequest);
    	return "success";
    	
    }*/
    
    @Action(value = "ExportAsPackagePdf", results = {
			@Result(name = "success", location = "success.page", type = "tiles"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	public String genertePdf() {
		try{
			list  = (List<com.projectazure.hibernate.beans.TourBooking>) beanMap.get("ShowList");
	Document document = new Document();
	document.setPageSize(PageSize.A4_LANDSCAPE);



	try {
		
		FileOutputStream out = new FileOutputStream(
				new File(
						"C:\\Users\\734473\\Desktop\\Test ExcelR\\new.pdf"));
		
		PdfWriter.getInstance(document, out);
		document.open();

		Paragraph title = new Paragraph("", FontFactory.getFont(
				FontFactory.HELVETICA, 18, Font.BOLD));
		Chapter chapter1 = new Chapter(title, 1);
		chapter1.setNumberDepth(0);

		Paragraph title1 = new Paragraph("Tour Package Report", FontFactory
				.getFont(FontFactory.HELVETICA, 18, Font.BOLD));
		chapter1.setNumberDepth(0);
		title1.setAlignment(Element.ALIGN_CENTER);

		Paragraph title2 = new Paragraph("The report is based on: ",
				FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD));
		chapter1.setNumberDepth(0);

		Paragraph title3 = new Paragraph("Tour Packages", FontFactory
				.getFont(FontFactory.HELVETICA, 12, Font.ITALIC));
		chapter1.setNumberDepth(0);

		PdfPTable table = new PdfPTable(3);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 8f, 16f, 16f});

		PdfPCell cell = new PdfPCell(new Phrase("S. No."));
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setBorderColor(BaseColor.BLACK);
		cell.setBorderWidth(1f);
		table.addCell(cell);

		PdfPCell cell1 = new PdfPCell(new Phrase("User ID"));
		cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell1.setVerticalAlignment(Element.ALIGN_CENTER);
		cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell1.setBorderColor(BaseColor.BLACK);
		cell1.setBorderWidth(1f);
		table.addCell(cell1);

		PdfPCell cell2 = new PdfPCell(new Phrase("Package ID"));
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell2.setVerticalAlignment(Element.ALIGN_CENTER);
		cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell2.setBorderColor(BaseColor.BLACK);
		cell2.setBorderWidth(1f);
		table.addCell(cell2);

		
		
		
		
		int i = 1;
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			com.projectazure.hibernate.beans.TourBooking tourBooking = (com.projectazure.hibernate.beans.TourBooking) iterator.next();
			Phrase phrase1 = new Phrase(String.valueOf(i));
			BaseColor color = new BaseColor(40, 40, 50);
			Font font = FontFactory.getFont(FontFactory.HELVETICA, 18,
					Font.ITALIC, color);
			phrase1.setFont(font);
			PdfPCell cell3 = new PdfPCell(phrase1);
			cell3
					.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
			cell3
					.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
			cell3.setBorderColor(BaseColor.BLACK);
			cell3.setBorderWidth(1f);
			table.addCell(cell3);

			
			String userID = Integer.toString(tourBooking.getUserId());
			
			PdfPCell cell4 = new PdfPCell(new Phrase(userID ));
			cell4
					.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
			cell4
					.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
			cell4.setBorderColor(BaseColor.BLACK);
			cell4.setBorderWidth(1f);
			table.addCell(cell4);

          
			
			
			String packageID = Integer.toString(tourBooking.getTourPackage().getPackageId());
		    PdfPCell cell5= new PdfPCell(new Phrase(packageID ));
		
			
			cell5
				.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
			cell5
					.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
			cell5.setBorderColor(BaseColor.BLACK);
			cell5.setBorderWidth(1f);
			table.addCell(cell5);

			
			i++;
		}

		/*Image image1 = Image.getInstance(getServletContext().getRealPath(
				"/images/Water lilies.jpg"));
		image1.scaleAbsolute(200f, 70f);*/
		document.setMarginMirroring(true);
		document.add(chapter1);
		/*document.add(image1);*/
		document.add(title1);
		document.add(title2);
		document.add(title3);
		document.add(Chunk.NEWLINE);
		document.add(table);
		document.close();

	} catch (DocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
return "success";
	}
catch(Exception e){}
	
	return "failure";
}
    
    
    
    @Action(value = "ExportAsPackageExcel", results = {
			@Result(name = "success", location = "success.page", type = "tiles"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	public String generteExcel() {

		try {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Sample sheet"); // Create a
																	// new
			// row in
			// current sheet
			Map<String, Object[]> data = new LinkedHashMap<String, Object[]>();
			data.put("1", new Object[] { "User ID","Package ID" });
			int i = 1;
			int rowCount = 2;
			list  = (List<com.projectazure.hibernate.beans.TourBooking>) beanMap.get("ShowList");
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				com.projectazure.hibernate.beans.TourBooking tourBooking = (com.projectazure.hibernate.beans.TourBooking) iterator.next();
				
				String UserID = Integer.toString(tourBooking.getUserId());
				String packageID = Integer.toString(tourBooking.getTourPackage().getPackageId());
				data.put(
						String.valueOf(rowCount),
						new Object[] { String.valueOf(i),
							
							UserID ,packageID });
						

				rowCount++;
				i++;
			}

			Set<String> keyset = data.keySet();
			int rownum = 0;
			for (String key : keyset) {
				HSSFRow row = sheet.createRow(rownum++);
				Object[] objArr = data.get(key);
				int cellnum = 0;
				for (Object obj : objArr) {
					HSSFCell cell = row.createCell(cellnum++);
					if (obj instanceof Date)
						cell.setCellValue((Date) obj);
					else if (obj instanceof Boolean)
						cell.setCellValue((Boolean) obj);
					else if (obj instanceof String)
						cell.setCellValue((String) obj);
					else if (obj instanceof Double)
						cell.setCellValue((Double) obj);
				}
			}
			try {
				FileOutputStream out = new FileOutputStream(new File(
						"C:\\Users\\734473\\Desktop\\Test Excel\\new.xls"));
				workbook.write(out);
				out.close();
				/* workbook.write(response.getOutputStream()); */
				System.out.println("Excel written successfully..");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "success";
		} catch (Exception e) {

		}
		//message = "Loyalty Points could not be viewed due to some issues. Please check the data you have entered .";

		return "failure";
	}
    
    
    
    
    
    
    
    
}
