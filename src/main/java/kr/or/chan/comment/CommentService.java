package kr.or.chan.comment;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@PropertySource("classpath:application.properties")
@Service
public class CommentService {
	@Value("${spring.datasource.file}")
	private String FILE_PATH;
	@Autowired
	private CommentDao commentDao;

	public List<Comment> getAllComment(int productId) {
		return commentDao.selectAllComment(productId);
	}

	public List<Comment> getTopThreeComment(int productId) {
		return commentDao.selectTopThreeComment(productId);
	}

	public Comment getTotalCountAndAverage(int productId) {
		return commentDao.getTotalCountAndAverage(productId);
	}

	@Transactional
	public int addComment(Comment comment) {
		return commentDao.insertComment(comment);
	}

	@Transactional
	public int addCommentWithImage(Comment comment, MultipartFile imageFile) {
		int commentId = addComment(comment);
		comment.setCommentId(commentId);

		int fileId = addCommentImage(comment, imageFile);
		comment.setFileId(fileId);

		return addCommentImageFileInfo(comment);
	}

	@Transactional
	public int addCommentImageFileInfo(Comment comment) {
		return commentDao.insertCommentFileInfo(comment);
	}

	@Transactional
	public int addCommentImage(Comment comment, MultipartFile imageFile) {
		String fileName = imageFile.getOriginalFilename() + comment.getCommentId();
		String saveFileName = "img/" + fileName;
		String contentType = imageFile.getContentType();

		comment.setFileName(fileName);
		comment.setSaveFileName(saveFileName);
		comment.setContentType(contentType);

		try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH + saveFileName); InputStream inputStream = imageFile.getInputStream();) {
			int readCount = 0;
			byte[] buffer = new byte[1024];

			while ((readCount = inputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, readCount);
			}

			return commentDao.insertCommentImage(comment);
		} catch (Exception ex) {
			throw new RuntimeException("file Save Error");
		}
	}
}
