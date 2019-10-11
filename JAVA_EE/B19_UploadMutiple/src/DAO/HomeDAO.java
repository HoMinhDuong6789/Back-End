package DAO;

import java.io.File;
import java.io.IOException;
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

public class HomeDAO {

	public static void Uploadsinglefile(HttpServletRequest request, HttpServletResponse response) {
		final String Address = "E:\\_Code\\_JavaEE\\B19_UploadMutiple\\filee";
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
			}
		}
	}

}
