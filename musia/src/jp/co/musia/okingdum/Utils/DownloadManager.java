package jp.co.musia.okingdum.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.musia.okingdum.Bean.ProductsBean;
import jp.co.musia.okingdum.dao.ProductsDao;

/**
 * Servlet implementation class DownloadManager
 */
@WebServlet("/DownloadManager")
public class DownloadManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String str_id = request.getParameter("id");
		
		if(str_id != null && !str_id.isEmpty()) {
		
			ProductsDao productsdao = new ProductsDao();
			ArrayList<ProductsBean> productsarr = new ArrayList<ProductsBean>();
			ProductsBean product = new ProductsBean();
			product.setProduct_id(str_id);
			productsarr = productsdao.selectProducts(new ArrayList<ProductsBean>(Arrays.asList(product)));
			
			if(productsdao.getErrflag()) {
				
				if(productsarr != null && productsarr.size() > 0) {

					product = productsarr.get(0);
					
					OutputStream out = response.getOutputStream();
					InputStream in = null;
					
					try {
				        response.setContentType("application/octet-stream");
				        response.setHeader(
				            "Content-Disposition",
				            "filename=\"" + product.getProduct_name() + "." + product.getFile_type() + "\"");
				        
				        in = new FileInputStream( "http://localhost:8080" + request.getContextPath() + product.getDirectory_path() );
				        out = response.getOutputStream();
				        byte[] buff = new byte[1024];
				        int len = 0;
				        while ((len = in.read(buff, 0, buff.length)) != -1) {
				            out.write(buff, 0, len);
				        }
				    } finally {
				        if (in != null) {
				            try {
				                in.close();
				            } catch (IOException e) {
				            }
				        }
				        if (out != null) {
				            try {
				                out.close();
				            } catch (IOException e) {
				            }
				        }
				    }
				} else {
					request.setAttribute("msg", Arrays.asList("商品が見つかりません。"));
				}
			} else {
				request.setAttribute("msg", productsdao.getMsg());
			}
		} else {
			request.setAttribute("msg", Arrays.asList("IDが不正です。"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
