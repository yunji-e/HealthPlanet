package com.dongduk.HealthPlanet.dao;

import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dongduk.HealthPlanet.domain.Post;

public class UserDAO {

    private JDBCUtil jdbcUtil = null;

    public UserDAO() {
        jdbcUtil = new JDBCUtil();
    };

    // 내가 참여한 모임 목록 조회
    public List<Post> findParticipationList(int id) {
        StringBuilder query = new StringBuilder();
        List<Post> list = new ArrayList<>();

        query.append("SELECT po.postid, title, schedule, po.state, custid ");
        query.append("FROM CUSTOMER c, POST po, PARTICIPATE pa ");
        query.append("WHERE c.id = pa.id AND po.postid = pa.postid ");
        query.append("ORDER BY state ASC, schedule DESC; ");
        jdbcUtil.setSqlAndParameters(query.toString(), null);

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                Post p = new Post(
                        rs.getInt("postid"),
                        rs.getString("title"),
                        rs.getDate("schedule"),
                        rs.getInt("state"),
                        rs.getString("custid")
                        );
                list.add(p);
            }
            return list;
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // 나의 찜 목록
    public List<Post> findWishList(int id) {
        StringBuilder query = new StringBuilder();
        List<Post> list = new ArrayList<>();

        query.append("SELECT po.postid, title, schedule, po.state, custid ");
        query.append("FROM CUSTOMER c, POST po, WISH w ");
        query.append("WHERE c.id = w.id AND po.postid = w.postid ");
        query.append("ORDER BY state ASC, schedule DESC; ");
        jdbcUtil.setSqlAndParameters(query.toString(), null);

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                Post p = new Post(
                        rs.getInt("postid"),
                        rs.getString("title"),
                        rs.getDate("schedule"),
                        rs.getInt("state"),
                        rs.getString("custid")
                        );
                list.add(p);
            }
            return list;
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // 내 모임 목록 조회
    public List<Post> findMyPostList(int id) {
        StringBuilder query = new StringBuilder();
        List<Post> list = new ArrayList<>();

        query.append("SELECT postid, title, schedule, custid ");
        query.append("FROM CUSTOMER JOIN POST USING(id) ");
        query.append("ORDER BY state ASC, schedule DESC; ");
        jdbcUtil.setSqlAndParameters(query.toString(), null);

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                Post p = new Post(
                        rs.getInt("postid"),
                        rs.getString("title"),
                        rs.getDate("schedule"),
                        rs.getString("time"),
                        rs.getString("custid")
                        );
                list.add(p);
            }
            return list;
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return null;
    }

    // 내 모임 조회
    public Post findMyPost(int id, int postid) {

        try {
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM CUSTOMER JOIN POST USING(id) ");
            query.append("WHERE id = ? AND postid = ?; ");

            jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {id, postid});
            ResultSet rs = jdbcUtil.executeQuery();

            if(rs.next()) {
                String title = rs.getString("title");
                Date schedule = rs.getDate("schedule");
                String time = rs.getString("timezone");
                String place = rs.getString("place");
                int headcount = rs.getInt("headcount");
                int cost = rs.getInt("cost");
                String custid = rs.getString("custid");
                String body = rs.getString("body");
                int event = rs.getInt("event");

                Post post = new Post(postid, title, schedule, time, place, headcount,
                        cost, body, custid, event);

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

    // 내 모임 수정(수정하기 버튼 -> 수정페이지)
    public Post findUpdatePost(int postid) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT title, schedule, timezone, place, headcount, cost, body, event ");
        query.append("FROM POST WHERE postid = ?; ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {postid});
        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
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
                query2.append("SELECT sportname FROM SPORTSCATEGORY ");
                query2.append("WHERE sportid = ?; ");
                jdbcUtil.setSqlAndParameters(query2.toString(), new Object[] {event});
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

    // 내 모임 수정(수정페이지 -> 수정완료)
    public int UpdatePost(int postid, String title, Date schedule, String time, String place, int headcount, int cost, String body, String sportname) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT sportid FROM SPORTSCATEGORY ");
        query.append("WHERE sportname = ?; ");
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {sportname});
        ResultSet rs = jdbcUtil.executeQuery();

        try {
            int sportid = 0;
            if(rs.next()) {
                // 운동 종목 id
                sportid = rs.getInt("sportid");
            }

            StringBuilder query2 = new StringBuilder();
            query2.append("UPDATE POST");
            query2.append("SET title = ?, schedule = ?, timezone = ?, place = ?, event = ? ");
            query2.append(" headcount = ?, cost = ?, body = ? ");
            query2.append("WHERE postid = ?; ");

            jdbcUtil.setSqlAndParameters(query2.toString(), new Object[] {title, schedule, time, place, sportid, headcount, cost, body, postid});

            int result = jdbcUtil.executeUpdate();
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

    // 내 모임 삭제
    public int deletePost(int postid) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM POST ");
        query.append("WHERE postid = ?; ");

        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {postid});
        try {
            int result = jdbcUtil.executeUpdate();
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
