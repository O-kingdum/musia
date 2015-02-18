package jp.co.musia.okingdum.dao;

import jp.co.musia.okingdum.Bean.UsersBean;

import java.sql.SQLException;
import java.text.*;
import java.util.*;

/**
 * UserDaoクラス
 * @author Tkray
 */
public class UserDao extends Dao {
    /**
     * insertUserメソッド : t_usersテーブルにインサートを行う
     *
     * @param user Users : UserBeanオブジェクト
     * @return int : 成功：1 失敗：0 データベースの失敗：-1
     */
    @SuppressWarnings("finally")
	public int insertUser(UsersBean user) {

        // 結果を格納
        int ret = 0;

        String mail = user.getEmail();
        String user_name = user.getUser_name();
        String passwd = user.getPassword();
        int sex = user.getSex();
        String birthday = user.getBirthday();

        // DBから性別に合ったuser_idの最大値を取得する
        try {
            // idの最大値
            int maxId = 0;
            // 男性：M 女性：W を格納
            String sexStr = "";

            String sql = "select max(cast(substring(f_user_id,2,6) as SIGNED)) as max_id," +
                    "substring(f_user_id,1,1) from t_users where substring(f_user_id,1,1) = ?;";

            // DBに接続
            this.getConnection();

            // ステートメントの作成
            ps = con.prepareStatement(sql);
            if (sex == 0) {
                sexStr = "M";
                ps.setString(1, sexStr);
            } else {
                sexStr = "W";
                ps.setString(1, sexStr);
            }

            // SQLの実行
            rs = ps.executeQuery();
            rs.next();
            // 性別に合わせたmaxIdを取得する
            maxId = rs.getInt("max_id");

            // インサートを行うIdを作成
            String insertId = sexStr + String.format("%1$06d", maxId + 1);

            //今日の日付日時を取得する
            Date date = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            String today = sdf1.format(date);

            sql = "insert into t_users(f_user_id,f_mail,f_name,f_password,f_birthday,f_entry_date,f_delflg) " +
                    "values(?,?,?,?,?,?,0);";

            ps = con.prepareStatement(sql);
            ps.setString(1, insertId);  // f_user_id
            ps.setString(2, mail);  // f_mail
            ps.setString(3, user_name);   // f_name
            ps.setString(4, passwd);  // f_password
            ps.setString(5, birthday);  // f_birthday
            ps.setString(6, today);  // f_today

            // インサートを実行する
            int result = ps.executeUpdate();

            if (result == 1) {
                System.out.println("インサートに成功しました");
                ret = 1;
            } else {
                System.out.println("インサートに失敗しました");
                ret =  0;
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DBの処理に失敗しました");
            ret =  -1;
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("DBの処理に失敗しました");
            ret =  -1;
        }finally {
            this.close();
            return ret;
        }
    }

    /**
     * changeUserDataメソッド : 指定ユーザの情報を変更する
     *
     * @param user UserBeanオブジェクト
     * @return 成功：1 失敗:0 データベースの失敗:-1
     */
    @SuppressWarnings("finally")
	public int changeUserData (UsersBean user) {
        
        int ret = 0;

        String user_id = user.getUser_id(); // テスト
        String mail = user.getEmail();
        String name = user.getUser_name();
        String password = user.getPassword();
        int sex = user.getSex();
        String birthday = user.getBirthday();
        String self_introduction = user.getSelf_introduction();
        int bank_number = user.getBank_number();
        int branch_code = user.getBranch_code();
        String bank_persons = user.getBank_persons();
        String bank_name = user.getBank_name();

        String sql = "update t_users " +
                "set f_mail = ?,f_name = ?, f_password = ?,f_birthday = ?, f_self_introduction = ?, f_bank_number = ?, f_branch_code = ?, f_bank_persons = ?, f_bank_name = ? " +
                "WHERE f_user_id = ?";
        
        try {
            // DBに接続
            this.getConnection();

            // ステートメントの作成
            ps = con.prepareStatement(sql);

            ps.setString(1, mail);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.setString(4, birthday);
            ps.setString(5, self_introduction);
            ps.setInt(6, bank_number);
            ps.setInt(7, branch_code);
            ps.setString(8, bank_persons);
            ps.setString(9, bank_name);
            ps.setString(10, user_id);
            
            //SQLを実行
            ret = ps.executeUpdate();
            
            if(ret == 1) {
                System.out.println("アップデートに成功しました");
            }else {
                System.out.println("アップデートに失敗しました");
                ret = 0;
            }

        }catch (SQLException e) {
            e.printStackTrace();
            ret = -1;
        }catch (Exception e) {
            e.printStackTrace();
            ret = -1;
        } finally {
        	this.close();
        	return ret;
        }
        
    }


    public static void main(String[] args) {
        UserDao ud = new UserDao();

        String mail = "aaa@gmail.com";
        String name = "hoge";
        int sex = 0;
        String passwd = "12345678";
        String birthday = "2015-01-01";


        UsersBean user1 = new UsersBean();

        //ud.insertUser(user1);
        ud.changeUserData(user1);
    }
}

