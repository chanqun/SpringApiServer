package kr.or.chan.reservation;

public class ReservationDaoSqls {
	public static final String SELECT_RESERVATION_INFO_BY_EMAIL = ""
		+ "SELECT reservation_info_id"
		+ "		, display_info_id"
		+ "		, reservation_info.product_id"
		+ "		, reservation_name"
		+ "		, reservation_tel"
		+ "		, reservation_email"
		+ "		, reservation_date"
		+ "		, cancel_flag "
		+ "		, reservation_info.create_date"
		+ "		, reservation_info.modify_date"
		+ "		, sum(count*price) as total_price "
		+ "FROM (product_price INNER JOIN reservation_info_price on product_price.id = reservation_info_price.product_price_id) "
		+ "INNER JOIN reservation_info ON reservation_info.id = reservation_info_price.reservation_info_id "
		+ "WHERE reservation_email = :reservationEmail "
		+ "GROUP BY reservation_info.id";
}
