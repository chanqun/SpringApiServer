package kr.or.chan.reservation;

public class ReservationDaoSqls {
	public static final String SELECT_RESERVATION_INFO_BY_EMAIL = ""
		+ "SELECT reservation_info_id"
		+ "		, display_info_id"
		+ "		, display_info.place_name"
		+ "		, product.description"
		+ "		, reservation_info.product_id"
		+ "		, reservation_info.reservation_name"
		+ "		, reservation_info.reservation_tel"
		+ "		, reservation_info.reservation_email"
		+ "		, reservation_info.reservation_date"
		+ "		, reservation_info.cancel_flag "
		+ "		, reservation_info.create_date"
		+ "		, reservation_info.modify_date"
		+ "		, ROUND(sum(count * (price - price * discount_rate / 100)), 0) as total_price "
		+ "FROM product_price "
		+ "JOIN reservation_info_price on product_price.id = reservation_info_price.product_price_id "
		+ "JOIN reservation_info ON reservation_info.id = reservation_info_price.reservation_info_id "
		+ "JOIN product ON product.id = reservation_info.product_id "
		+ "JOIN display_info ON display_info.product_id = product.id "
		+ "WHERE reservation_email=:reservationEmail "
		+ "GROUP BY reservation_info.id";
}
