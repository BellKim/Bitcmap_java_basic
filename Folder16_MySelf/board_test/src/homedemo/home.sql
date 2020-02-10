SELECT * FROM home_member;

CREATE TABLE home_member(
	join_date date,
	num number,
	id varchar(10),
	pw varchar(20),
	phone_no number,
	email varchar(20)
);

create sequence home_member_seq start with 1 increment by 1;

INSERT INTO home_member(join_date, num, id, pw, phone_no, email)
values(joindate, num, 테스트, test, test, 01012345678, test@esvpn.co.kr);