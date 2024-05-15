package com.dongduk.HealthPlanet.model.dao;

import java.sql.ResultSet;
import java.util.Date;

import com.dongduk.HealthPlanet.model.Post;

public class postDAO {

    private JDBCUtil jdbcUtil = null;

    public postDAO() {
        jdbcUtil = new JDBCUtil();
    };

    // 모임 조회
    public Post findPost(int postid) {
        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM CUSTOMER JOIN POST USING(id) ");
            query.append("WHERE postid = ?; ");

            jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {postid});
            ResultSet rs = jdbcUtil.executeQuery();

            if(rs.next()) {
                String title = rs.getString("title");
                Date schedule = rs.getDate("schedule");
                String time = rs.getString("timezone");
                String place = rs.getString("place");
                int headcount = rs.getInt("headcount");
                int cost = rs.getInt("cost");
                String body = rs.getString("body");
                int event = rs.getInt("event");

                Post post = new Post(postid, title, schedule, time, place, headcount,
                        cost, body, event);

                StringBuilder query2 = new StringBuilder();
                query2.append("SELECT count(*) AS applicant FROM PARTICIPATE ");
                query2.append("WHERE postid = ? AND state = 1; ");
                jdbcUtil.setSqlAndParameters(query2.toString(), new Object[] {postid});
                rs = jdbcUtil.executeQuery();

                if(rs.next()) {
                    // 신청자 수
                    int applicant = rs.getInt("applicant");
                    post.setApplicant(applicant);
                 }

                StringBuilder query3 = new StringBuilder();
                query3.append("SELECT sportname FROM SPORTSCATEGORY ");
                query3.append("WHERE sportid = ?; ");
                jdbcUtil.setSqlAndParameters(query3.toString(), new Object[] {event});
                rs = jdbcUtil.executeQuery();

                if(rs.next()) {
                    // 운동 종목
                    String sportname = rs.getString("sportname");
                    post.setSportname(sportname);
                }
                return post;
            }

        } catch (Exception ex){
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }

        return null;
    }

    // 모임 신청
    public int participatePost(int id, int postid) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO PARTICIPATE ");
        query.append("VALUES (?, ?, 1) ");
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {postid, id});

        try {
            int result = jdbcUtil.executeUpdate();

            if (result == 1) {
                StringBuilder query2 = new StringBuilder();
                // 모집 완료
                query2.append("UPDATE POST SET state = 1 ");
                query2.append("WHERE postid = ? AND headcount = (SELECT count(*) FROM PARTICIPATE WHERE postid = ?); ");
                jdbcUtil.setSqlAndParameters(query2.toString(), new Object[] {postid, postid});

                result = jdbcUtil.executeUpdate();
                return result;
            }

        } catch (Exception ex){
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }

        return 0;
    }

    // 모임 신청 취소(모임 조회에서 취소)
    int cancelParticipation(int id, int postid) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM PARTICIPATE ");
        query.append("WHERE postid = ? AND id = ?; ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {postid, id});
        try {
            int result = jdbcUtil.executeUpdate();
            if (result == 1) {
                StringBuilder query2 = new StringBuilder();
                query2.append("UPDATE POST SET state = 0 ");
                query2.append("WHERE postid = ? AND headcount > (SELECT count(*) FROM PARTICIPATE WHERE postid = ?);");
                jdbcUtil.setSqlAndParameters(query2.toString(), new Object[] {postid, postid});

                result = jdbcUtil.executeUpdate();
                return result;
            }
            return result;
        } catch (Exception ex){
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }

        return 0;
    }

    // 찜하기
    int addWish(int id, int postid) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO WISH ");
        query.append("VALUES(?, ?) ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {id, postid});
        try {
            int result = jdbcUtil.executeUpdate();
            if (result == 1) {
                StringBuilder query2 = new StringBuilder();
                query2.append("UPDATE POST ");
                query2.append("SET wish = wish + 1 ");
                query2.append("WHERE postid = ?; ");
                jdbcUtil.setSqlAndParameters(query2.toString(), new Object[] {postid});

                result = jdbcUtil.executeUpdate();
                return result;
            }
            return result;
        } catch (Exception ex){
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }

        return 0;
    }

    // 찜 삭제(모임 조회에서 삭제)
    int deleteWish(int id, int postid) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM WISH ");
        query.append("WHERE postid = ?, id = ?; ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {postid, id});
        try {
            int result = jdbcUtil.executeUpdate();
            if (result == 1) {
                StringBuilder query2 = new StringBuilder();
                query2.append("UPDATE POST ");
                query2.append("SET wish = wish - 1 ");
                query2.append("WHERE postid = ?; ");
                jdbcUtil.setSqlAndParameters(query2.toString(), new Object[] {postid});

                result = jdbcUtil.executeUpdate();
                return result;
            }
            return result;
        } catch (Exception ex){
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }

        return 0;
    }
}
