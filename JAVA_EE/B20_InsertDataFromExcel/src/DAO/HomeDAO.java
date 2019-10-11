package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import BEAN.Student;
import BEAN.Studentt;
import DB.DBConnection;

public class HomeDAO {
	public static String msg="Import Success \t";

	public static void Uploadsinglefile(HttpServletRequest request, HttpServletResponse response) {
		final String Address = "E:\\_Code\\_JavaEE\\B20_InsertDataFromExcel\\filee";
		final int yourMaxMemorySize = 1024 * 1024 * 3; // 3mb
		final int yourMaxRequestSize = 1024 * 1024 * 50; // 50mb
			
		boolean isMultipart = ServletFileUpload.isMultipartContent(request); // dung de kiem tra ltv da them
																				// enctype="multipart/form-data" vao the
																				// input chua
		if (!isMultipart) {
			request.setAttribute("mes", "not have enctype=\"multipart/form-data\"");
		} else {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Set factory constraints
			factory.setSizeThreshold(yourMaxMemorySize);
			factory.setRepository(new java.io.File(System.getProperty("java.io.tmpdir")));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// de sxu ly upload file ta su dung ServletUpload

			// Set overall request size constraint
			upload.setSizeMax(yourMaxRequestSize);

			try {
				// Parse the request
				List<FileItem> items = upload.parseRequest(request);

				// Process the uploaded items
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();
					// iter : la no se lay file do va dua vao file item

					if (!item.isFormField()) {
						String filename = item.getName();
						// path file: vi tri de copy file vao, gui cho server
						String pathFile = Address + File.separator + filename;
						System.out.println(pathFile);
						// Process a file upload
						File uploadedFile = new File(pathFile);
						if (uploadedFile.exists() == true) {
							request.setAttribute("mes", "file exists");
						} else {
							item.write(uploadedFile);
							request.setAttribute("mes", "upload file success");
						}
					} else {
						request.setAttribute("mes", "upload file failer");
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				request.setAttribute("mes", e.getMessage());
				// e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				request.setAttribute("mes", e.getMessage());
			}

			RequestDispatcher rd = request.getRequestDispatcher("view/Result.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg=e.getMessage();
			}
		}
	}

	public static void ImportExcel(HttpServletRequest request, HttpServletResponse response) {
		InputStream imp; // ho tro doc file vao
		try {
			imp = new FileInputStream("E:\\_Code\\_JavaEE\\B20_InsertDataFromExcel\\filee\\studentt.xls");

			HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(imp));

			Sheet sheet = wb.getSheetAt(1); // tro toi sheet thuc thi 0->1
			// vong lap de doc tung dong trong sheet
			Connection conn;
			try {
				conn = DBConnection.CreateConnection();
				for (int i = 0; i < sheet.getLastRowNum(); i++) {
					// tro toi hang
					Row row = sheet.getRow(i);

					int id = (int) row.getCell(0).getNumericCellValue();
					String hoten = row.getCell(1).getStringCellValue();
					String quequan = row.getCell(2).getStringCellValue();
					Studentt studentt = new Studentt(id, hoten, quequan);
					HomeDAO.InsertUsers(conn, studentt);

				}
				wb.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg=e.getMessage();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", msg);
			e.printStackTrace();
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("view/Result.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg= e.getMessage();
		}

	}
	
	public static boolean InsertUsers(Connection conn, Studentt studentt) {
		PreparedStatement ptmt = null;
		String sql = "INSERT INTO studentt(id,hoten,quequan) " + "VALUES (?,?,?)";					
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, studentt.getId());
			ptmt.setString(2,studentt.getHoten());
			ptmt.setString(3, studentt.getQuequan());
			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			}
			
			ptmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg=e.getMessage();
			e.printStackTrace();
		}
		return false;
	}
}
