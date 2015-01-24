package jp.co.musia;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

public class Validator {

	private ArrayList<String> errmsg;
	private boolean valid;
	
	/**
	 * getErrMsg���\�b�h : �G���[���b�Z�[�W�̎擾
	 * 
	 * @return errmsg ArrayList<String>: �o���f�[�V�����G���[���b�Z�[�W���X�g
	 */
	public ArrayList<String> getErrMsg() {
		return this.errmsg;
	}
	
	/**
	 * getLoginValidation���\�b�h : ���O�C�����̓��͂ɑ΂���o���f�[�V����
	 * 
	 * @param email String: ���[���A�h���X
	 * @param password String:�@�p�X���[�h
	 * @return valid boolean:�@�o���f�[�V��������
	 */
	public boolean getLoginValidation(String email, String password) {
		// �G���[���b�Z�[�W���X�g������
		this.errmsg = new ArrayList<String>();
		// �o���f�[�V�������菉����
		this.valid = true;
		
		/* email Validation */
		if(StringUtils.isEmpty(email)) {	// ��܂���null
			valid = false;
			errmsg.add("���[���A�h���X����͂��Ă��������B");
		} else {
			if(!email.matches("[0-9a-zA-Z]+")) {
				valid = false;
				errmsg.add("���[���A�h���X�͔��p�p�����œ��͂��Ă��������B");
			}			
			if(email.length() > 50) {
				valid = false;
				errmsg.add("���[���A�h���X��50�����ȓ��œ��͂��Ă��������B");
			}
		}
		/* password Validation */
		if(StringUtils.isEmpty(password)) {	// ��܂���null
			valid = false;
			errmsg.add("�p�X���[�h����͂��Ă��������B");
		} else {
			if(!password.matches("[0-9a-zA-Z]+")) {
				valid = false;
				errmsg.add("�p�X���[�h�͔��p�p�����œ��͂��Ă��������B");
			}
			if(email.length() >= 6 && email.length() <= 8) {
				valid = false;
				errmsg.add("�p�X���[�h��6~8�����œ��͂��Ă��������B");
			}
		}
		return valid;
	}
	
	public boolean getCreditValidation(String card_number, String limit_date, String card_company,
			String sec_code, String card_persons) {
		// �G���[���b�Z�[�W���X�g������
		this.errmsg = new ArrayList<String>();
		// �o���f�[�V�������菉����
		this.valid = true;
		
		/* card_number Validation */
		if(StringUtils.isEmpty(card_number)) {
			valid = false;
			errmsg.add("�N���W�b�g�J�[�h�ԍ�����͂��Ă��������B");
		} else {
			if(!card_number.matches("[0-9]+")) {
				valid = false;
				errmsg.add("�N���W�b�g�J�[�h�ԍ��͔��p�p�����œ��͂��ĉ������B");
			}
			if(card_number.length() != 16) {
				valid = false;
				errmsg.add("�N���W�b�g�J�[�h�ԍ���16�����œ��͂��Ă��������B");
			}
		}
		/* limit_date Validation */
		if(StringUtils.isEmpty(limit_date)) {
			valid = false;
			errmsg.add("�L����������͂��Ă��������B");
		} else {
			if(!card_number.matches("^[0-9]{4}-{1}[0-9]{2}")) {
				valid = false;
				errmsg.add("�L�������̌`��������������܂���B");
			}
		}
		/**/
		return valid;
	}
}
