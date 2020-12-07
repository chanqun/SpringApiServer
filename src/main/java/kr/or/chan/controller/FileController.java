package kr.or.chan.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.chan.productimage.ProductImage;
import kr.or.chan.productimage.ProductImageService;

@PropertySource("classpath:application.properties")
@RestController
@RequestMapping("/api/file")
public class FileController {
	@Value("${spring.datasource.file}")
	private String FILE_PATH;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProductImageService productImageService;

	@GetMapping
	public void getImageByFileId(@RequestParam int fileId, HttpServletResponse response) {
		ProductImage productImage = productImageService.getProductImageByFileId(fileId);

		response.setHeader("Content-Disposition", "attachment; filename=\"" + productImage.getFileName() + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");

		try (FileInputStream fis = new FileInputStream(FILE_PATH + productImage.getSaveFileName()); OutputStream out = response.getOutputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];

			while ((readCount = fis.read(buffer)) != -1) {
				out.write(buffer, 0, readCount);
			}
		} catch (IOException ex) {
			logger.warn("Excption [getImageByFileId] fileId : {}", fileId, ex);
		}
	}
}
