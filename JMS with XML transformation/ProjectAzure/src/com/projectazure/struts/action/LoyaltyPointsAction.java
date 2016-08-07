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

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Namespaces;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.projectazure.dao.LoyaltyPointsDao;
import com.projectazure.service.LoyaltyPointsService;
import com.projectazure.struts.beans.LoyaltyPoints;
import com.projectazure.struts.beans.TourPackage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Namespaces(value = { @Namespace("/module3/admin/pages"), @Namespace("/") })
public class LoyaltyPointsAction extends ActionSupport implements
		ModelDriven<LoyaltyPoints>, SessionAware {
	private static final long serialVersionUID = 1L;
	LoyaltyPointsService loyaltyPointsService = new LoyaltyPointsService();
	List<LoyaltyPoints> loyaltyPointsList = new ArrayList<LoyaltyPoints>();
	List<com.projectazure.hibernate.beans.LoyaltyPoints> loyaltyPointsReportList = new ArrayList<com.projectazure.hibernate.beans.LoyaltyPoints>();
	List<com.projectazure.hibernate.beans.LoyaltyPoints> loyaltyPointsUpdateList = new ArrayList<com.projectazure.hibernate.beans.LoyaltyPoints>();
	com.projectazure.struts.beans.LoyaltyPoints loyaltyPoints1 = new com.projectazure.struts.beans.LoyaltyPoints();
	com.projectazure.struts.beans.LoyaltyPoints loyaltyPoints2 = new com.projectazure.struts.beans.LoyaltyPoints();
	LoyaltyPointsDao loyaltyPointsDao = new LoyaltyPointsDao();

	private Map sessionMap;

	int loyaltyReportPoints;

	public int getLoyaltyReportPoints() {
		return loyaltyReportPoints;
	}

	public void setLoyaltyReportPoints(int loyaltyReportPoints) {
		this.loyaltyReportPoints = loyaltyReportPoints;
	}

	int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	LoyaltyPoints loyaltyPoints = new LoyaltyPoints();
	LoyaltyPoints updateObject = new LoyaltyPoints();

	private String validate;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	String message = new String();

	public LoyaltyPoints getModel() {
		// TODO Auto-generated method stub
		return loyaltyPoints;
	}

	/*
	 * @Action(value = "AddLoyaltyPoints", results = {
	 * 
	 * @Result(name = "AddLoyaltyPoints", location = "AddLoyaltyPoints.page",
	 * type = "tiles"),
	 * 
	 * @Result(name = "failure", location = "failure.page", type = "tiles") })
	 * public String addLoyaltyPoints() { try {
	 * 
	 * return "AddLoyaltyPoints"; } catch (Exception e) {
	 * 
	 * } message = "Add Loyalty Points page cannot be viewed Properly";
	 * 
	 * return "failure"; }
	 */
	/*
	 * @Action(value = "addLoyaltyPointsAction", results = {
	 * 
	 * @Result(name = "success", location = "success.page", type = "tiles"),
	 * 
	 * @Result(name = "failure", location = "failure.page", type = "tiles") })
	 * public String editLoyaltyPoints() { try { boolean success =
	 * loyaltyPointsDao.isAvailable(loyaltyPoints2.getUserId()); if (success){
	 * int loyatyPointsValue = loyaltyPoints2.getLoyaltyPoints(); int
	 * newLoyatyPointsValue=loyatyPointsValue+300;
	 * loyaltyPointsService.updateLoyaltyPointsValue(loyaltyPoints2,
	 * newLoyatyPointsValue); return "success"; } else{
	 * loyaltyPointsService.addLoyaltyPoints(loyaltyPoints2); return "success";
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } message =
	 * "College could not be registered due to some issues. Please check the data you have entered or contact administrator for assistance"
	 * ;
	 * 
	 * return "failure"; }
	 */

	/*
	 * @Action(value = "VieweditLoyaltyPoints", results = { @Result(name =
	 * "VieweditLoyaltyPoints", location = "EditLoyaltyPoints.page", type =
	 * "tiles") }) public String EditLoyaltyPoints() {
	 * 
	 * try {
	 * 
	 * return "VieweditLoyaltyPoints"; } catch (Exception e) {
	 * 
	 * } message =
	 * "TourPackage could not be registered due to some issues. Please check the data you have entered ."
	 * ;
	 * 
	 * return "failure"; }
	 */
	@Action(value = "ViewAllLoyaltyPoints", results = {
			@Result(name = "ViewAllLoyaltyPoints", location = "AllLoyaltyPoints.page", type = "tiles"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	public String ViewAllLoyaltyPoints() {

		try {

			loyaltyPointsList = loyaltyPointsService.viewLoyaltyPoints();
			System.out.println(loyaltyPointsList.get(0).getLoyaltyPointsId());
			sessionMap.put("loyaltyPointsList", loyaltyPointsList);

			return "ViewAllLoyaltyPoints";
		} catch (Exception e) {

		}
		message = "Loyalty Points could not be viewed due to some issues. Please check the data you have entered .";

		return "failure";
	}

	@Action(value = "viewUpdateLoyaltyPoints", results = {
			@Result(name = "viewUpdateLoyaltyPoints", location = "viewUpdateLoyaltyPoints.page", type = "tiles"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	public String viewUpdateLoyaltyPoints() {

		try {
			System.out.println(validate);

			updateObject = loyaltyPointsService.viewUpdateLoyaltyPoints(Integer
					.parseInt(validate));
			sessionMap.put("updateObject", updateObject);

			return "viewUpdateLoyaltyPoints";
		} catch (Exception e) {

		}
		message = "Loyalty Points could not be viewed due to some issues. Please check the data you have entered .";

		return "failure";
	}

	@Action(value = "updateLoyaltyPoints", results = {
			@Result(name = "success", location = "ViewAllLoyaltyPoints", type = "redirect"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	public String updateLoyaltyPoints() {

		try {

			System.out.println(loyaltyPoints.getUserId());
			loyaltyPointsService
					.updateLoyaltyPoints(loyaltyPoints, getUserId());
			message = "Loyalty points  succesfully edited";
			sessionMap.put("message", message);
			return "success";
		} catch (Exception e) {
			message = "Loyalty Points could not be updated due to some issues. Please check the data you have entered .";

			sessionMap.put("message", message);
			e.printStackTrace();
		}

		return "failure";
	}

	@Action(value = "loyaltyReport", results = {
			@Result(name = "loyaltyReport", location = "loyaltyReport.page", type = "tiles"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	public String generateLoyaltyPoints() {

		try {

			loyaltyPointsReportList = loyaltyPointsService
					.generateLoyaltyPoints(getLoyaltyReportPoints());
			sessionMap.put("loyaltyPointsReportList", loyaltyPointsReportList);
			System.out.println(loyaltyPointsList.toString());

			return "loyaltyReport";
		} catch (Exception e) {

		}
		message = "Loyalty Points could not be viewed due to some issues. Please check the data you have entered .";

		return "failure";
	}

	@Action(value = "loyaltyReportView", results = {
			@Result(name = "loyaltyReportView", location = "loyaltyReportView.page", type = "tiles"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	public String loyaltyReportView() {

		try {

			return "loyaltyReportView";
		} catch (Exception e) {

		}
		message = "Loyalty Points could not be viewed due to some issues. Please check the data you have entered .";

		return "failure";
	}

	@Action(value = "exportAsEXCEL", results = {
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
			data.put("1", new Object[] { "S.No", "LoyaltyPoints ID",
					"Loyalty Points", "Achieved By", "Achieved Date",
					"Expiry Date", "User ID" });
			int i = 1;
			int rowCount = 2;
			loyaltyPointsReportList = (List<com.projectazure.hibernate.beans.LoyaltyPoints>) sessionMap
					.get("loyaltyPointsReportList");
			Iterator iterator = loyaltyPointsReportList.iterator();
			while (iterator.hasNext()) {
				com.projectazure.hibernate.beans.LoyaltyPoints loyaltyPoints = (com.projectazure.hibernate.beans.LoyaltyPoints) iterator
						.next();
				String LoyaltyPointsID = Integer.toString(loyaltyPoints
						.getLoyaltyPointsId());
				String loyaltyPointsR = Integer.toString(loyaltyPoints
						.getLoyaltyPoints());

				String userIDRR = Integer.toString(loyaltyPoints.getUserId());

				data.put(
						String.valueOf(rowCount),
						new Object[] { String.valueOf(i), LoyaltyPointsID,
								loyaltyPointsR, loyaltyPoints.getAchievedBy(),
								loyaltyPoints.getAchievedDate(),
								loyaltyPoints.getExpiryDate(), userIDRR });

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
						"C:\\Users\\772825\\Desktop\\Test Excel\\new.xls"));
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
		message = "Loyalty Points could not be viewed due to some issues. Please check the data you have entered .";

		return "failure";
	}

	@Action(value = "exportAsPDF", results = {
			@Result(name = "success", location = "success.page", type = "tiles"),
			@Result(name = "failure", location = "failure.page", type = "tiles") })
	public String genertePdf() {
		try {
			loyaltyPointsReportList = (List<com.projectazure.hibernate.beans.LoyaltyPoints>) sessionMap
					.get("loyaltyPointsReportList");
			Document document = new Document();
			document.setPageSize(PageSize.A4_LANDSCAPE);

			try {

				FileOutputStream out = new FileOutputStream(new File(
						"C:\\Users\\772825\\Desktop\\Test Excel\\new.pdf"));

				PdfWriter.getInstance(document, out);
				document.open();

				Paragraph title = new Paragraph("", FontFactory.getFont(
						FontFactory.HELVETICA, 18, Font.BOLD));
				Chapter chapter1 = new Chapter(title, 1);
				chapter1.setNumberDepth(0);

				Paragraph title1 = new Paragraph("College report",
						FontFactory.getFont(FontFactory.HELVETICA, 18,
								Font.BOLD));
				chapter1.setNumberDepth(0);
				title1.setAlignment(Element.ALIGN_CENTER);

				Paragraph title2 = new Paragraph("The report is based on: ",
						FontFactory.getFont(FontFactory.HELVETICA, 13,
								Font.BOLD));
				chapter1.setNumberDepth(0);

				Paragraph title3 = new Paragraph("Loyalty Points",
						FontFactory.getFont(FontFactory.HELVETICA, 12,
								Font.ITALIC));
				chapter1.setNumberDepth(0);

				PdfPTable table = new PdfPTable(7);
				table.setWidthPercentage(100f);
				table.setWidths(new float[] { 8f, 16f, 23f, 17f, 17f, 17f, 17f });

				PdfPCell cell = new PdfPCell(new Phrase("S. No."));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_CENTER);
				cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
				cell.setBorderColor(BaseColor.BLACK);
				cell.setBorderWidth(1f);
				table.addCell(cell);

				PdfPCell cell1 = new PdfPCell(new Phrase("Loyalty Points ID"));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setVerticalAlignment(Element.ALIGN_CENTER);
				cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
				cell1.setBorderColor(BaseColor.BLACK);
				cell1.setBorderWidth(1f);
				table.addCell(cell1);

				PdfPCell cell2 = new PdfPCell(new Phrase("Loyalty Points"));
				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell2.setVerticalAlignment(Element.ALIGN_CENTER);
				cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
				cell2.setBorderColor(BaseColor.BLACK);
				cell2.setBorderWidth(1f);
				table.addCell(cell2);

				PdfPCell cell3 = new PdfPCell(new Phrase("Achieved By"));
				cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell3.setVerticalAlignment(Element.ALIGN_CENTER);
				cell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
				cell3.setBorderColor(BaseColor.BLACK);
				cell3.setBorderWidth(1f);
				table.addCell(cell3);

				PdfPCell cell4 = new PdfPCell(new Phrase("Achieved Date"));
				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell4.setVerticalAlignment(Element.ALIGN_CENTER);
				cell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
				cell4.setBorderColor(BaseColor.BLACK);
				cell4.setBorderWidth(1f);
				table.addCell(cell4);

				PdfPCell cell5 = new PdfPCell(new Phrase("Expiry Date"));
				cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell5.setVerticalAlignment(Element.ALIGN_CENTER);
				cell5.setBackgroundColor(BaseColor.LIGHT_GRAY);
				cell5.setBorderColor(BaseColor.BLACK);
				cell5.setBorderWidth(1f);
				table.addCell(cell5);

				PdfPCell cell6 = new PdfPCell(new Phrase("User ID"));
				cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell6.setVerticalAlignment(Element.ALIGN_CENTER);
				cell6.setBackgroundColor(BaseColor.LIGHT_GRAY);
				cell6.setBorderColor(BaseColor.BLACK);
				cell6.setBorderWidth(1f);
				table.addCell(cell6);

				int i = 1;
				Iterator iterator = loyaltyPointsReportList.iterator();
				while (iterator.hasNext()) {
					com.projectazure.hibernate.beans.LoyaltyPoints loyaltyPoints = (com.projectazure.hibernate.beans.LoyaltyPoints) iterator
							.next();
					Phrase phrase1 = new Phrase(String.valueOf(i));
					BaseColor color = new BaseColor(40, 40, 50);
					Font font = FontFactory.getFont(FontFactory.HELVETICA, 18,
							Font.ITALIC, color);
					phrase1.setFont(font);
					PdfPCell cell7 = new PdfPCell(phrase1);
					cell7.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
					cell7.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
					cell7.setBorderColor(BaseColor.BLACK);
					cell7.setBorderWidth(1f);
					table.addCell(cell7);

					String loyaltyPointsIdR = Integer.toString(loyaltyPoints
							.getLoyaltyPointsId());
					PdfPCell cell8 = new PdfPCell(new Phrase(loyaltyPointsIdR));
					cell8.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
					cell8.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
					cell8.setBorderColor(BaseColor.BLACK);
					cell8.setBorderWidth(1f);
					table.addCell(cell8);

					String loyaltyPointsR = Integer.toString(loyaltyPoints
							.getLoyaltyPoints());
					PdfPCell cell9 = new PdfPCell(new Phrase(loyaltyPointsR));

					cell9.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
					cell9.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
					cell9.setBorderColor(BaseColor.BLACK);
					cell9.setBorderWidth(1f);
					table.addCell(cell9);

					PdfPCell cell10 = new PdfPCell(new Phrase(
							loyaltyPoints.getAchievedBy()));
					cell10.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
					cell10.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
					cell10.setBorderColor(BaseColor.BLACK);
					cell10.setBorderWidth(1f);
					table.addCell(cell10);

					DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
					String reportDate = df.format(loyaltyPoints
							.getAchievedDate());
					PdfPCell cell11 = new PdfPCell(new Phrase(reportDate));
					cell11.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
					cell11.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
					cell11.setBorderColor(BaseColor.BLACK);
					cell11.setBorderWidth(1f);
					table.addCell(cell11);

					String reportDate1 = df.format(loyaltyPoints
							.getExpiryDate());
					PdfPCell cell12 = new PdfPCell(new Phrase(reportDate1));
					cell12.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
					cell12.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
					cell12.setBorderColor(BaseColor.BLACK);
					cell12.setBorderWidth(1f);
					table.addCell(cell12);

					String userIdR = Integer
							.toString(loyaltyPoints.getUserId());
					PdfPCell cell13 = new PdfPCell(new Phrase(userIdR));
					cell13.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
					cell13.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
					cell13.setBorderColor(BaseColor.BLACK);
					cell13.setBorderWidth(1f);
					table.addCell(cell13);

					i++;
				}

				/*
				 * Image image1 =
				 * Image.getInstance(getServletContext().getRealPath(
				 * "/images/Water lilies.jpg")); image1.scaleAbsolute(200f,
				 * 70f);
				 */
				document.setMarginMirroring(true);
				document.add(chapter1);
				/* document.add(image1); */
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
		} catch (Exception e) {
		}

		return "failure";
	}

	public void setSession(Map map) {
		this.sessionMap = map;

	}

}
