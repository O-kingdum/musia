package jp.co.musia.dao;

import jp.co.musia.okingdum.Users;

import java.sql.SQLException;

/**
 * Created by Tkray on 15/01/28.
 */
public class UserDao extends Dao {


    /**
     * insertUserメソッド : t_usersテーブルにインサートを行う
     *
     * @param user Users : Usersクラス
     * @return int : インサートの結果
     */
    public int insertUser(Users user) {

        String mail = user.getMail();
        String user_name = user.getName();
        String passwd = user.getPassword();
        String sex = user.getSex();
        String birthday = user.getBirthday();  // もしかしたらString型じゃないかも

        // DBから性別に合ったuser_idの最大値を取得する
        try {
            // idの最大値
            int maxId = 0;

            String sql = "select max(cast(substring(f_user_id,2,6) as SIGNED))," +
                    "substring(f_user_id,1,1) from t_users where substring(f_user_id,1,1) = ?;";

            // DBに接続
            this.getConnection();

            try {
                // ステートメントの作成
                ps = con.prepareStatement(sql);
                if (sex.equals("man")) {
                    ps.setString(1, "M");
                }else {
                    ps.setString(1, "W");
                }

                // SQLの実行
                rs = ps.executeQuery();

                maxId = rs.getInt("max(cast(substring(f_user_id,2,6) as SIGNED))");

                System.out.println(maxId);


            }catch (SQLException e) {

            }catch (Exception e) {

            }



        } catch (Exception e) {

        }

        //インサートを行うためのinsert_idを作成

        //インサートを行う時間を取得


        return 0;
    }

    public static void main(String[] args) {
        UserDao ud = new UserDao();

        Users user1 = new Users();

        user1.setMail("aaa@gmail.com");
        user1.setName("hoge");
        user1.setSex("man");
        user1.setPassword("12345678");
        user1.setBirthday("2015-01-01");

        ud.insertUser(user1);
    }
}

