package jp.co.musia;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

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
	 * getSearchMusic���\�b�h : �y�Ȍ�����͂ɑ΂���o���f�[�V����
	 * 
	 * @param value String: �y�Ȗ�
	 * @return�@valid boolean: �o���f�[�V��������
	 */
	public boolean getSearchMusic(String value) {
		// �G���[���b�Z�[�W���X�g����
		this.errmsg = new ArrayList<String>();
		// �o���f�[�V�������菉��
		this.valid = true;
		
		if(StringUtils.isEmpty(value)) {
			valid = false;
			errmsg.add("�y�Ȗ����͂��Ă��������B");
		} else {
			if(value.length() > 20) {
				valid = false;
				errmsg.add("�y�Ȗ���20�����ȓ��œ�͂��ĉ������B");
			}
		}
		return valid;
	}
	/**
	 * getLoginValidation���\�b�h : ���O�C�����̓�͂ɑ΂���o���f�[�V����
	 * 
	 * @param email String: ���[���A�h���X
	 * @param password String:�@�p�X���[�h
	 * @return valid boolean:�@�o���f�[�V��������
	 */
	public boolean getLoginValidation(String email, String password) {
		// �G���[���b�Z�[�W���X�g����
		this.errmsg = new ArrayList<String>();
		// �o���f�[�V�������菉��
		this.valid = true;
		
		/* email Validation */
		if(StringUtils.isEmpty(email)) {	// ��܂���null
			valid = false;
			errmsg.add("���[���A�h���X���͂��Ă��������B");
		} else {
			if(!email.matches("[0-9a-zA-Z]+")) {
				valid = false;
				errmsg.add("���[���A�h���X�͔��p�p�����œ�͂��Ă��������B");
			}			
			if(email.length() > 50) {
				valid = false;
				errmsg.add("���[���A�h���X��50�����ȓ��œ�͂��Ă��������B");
			}
		}
		/* password Validation */
		if(StringUtils.isEmpty(password)) {	// ��܂���null
			valid = false;
			errmsg.add("�p�X���[�h���͂��Ă��������B");
		} else {
			if(!password.matches("[0-9a-zA-Z]+")) {
				valid = false;
				errmsg.add("�p�X���[�h�͔��p�p�����œ�͂��Ă��������B");
			}
			if(password.length() >= 6 && password.length() <= 8) {
				valid = false;
				errmsg.add("�p�X���[�h��6~8�����œ�͂��Ă��������B");
			}
		}
		return valid;
	}
	/**
	 * getBankAddValidation���\�b�h : ��s����o�^�����ɑ΂���o���f�[�V����
	 * 
	 * @param bank_number String: ����ԍ�
	 * @param branch_code String: �x�X�ԍ�
	 * @param bank_persons String: ������`�l
	 * @param bank_name String: ��s��
	 * @return valid boolean: �o���f�[�V��������
	 */
	public boolean getBankAddValidation(String bank_number, String branch_code,
			String bank_persons, String bank_name) {
		// �G���[���b�Z�[�W���X�g����
		this.errmsg = new ArrayList<String>();
		// �o���f�[�V�������菉��
		this.valid = true;
		
		/* bank_number Validation */
		if(StringUtils.isEmpty(bank_number)) {
			valid = false;
			errmsg.add("����ԍ����͂��Ă��������B");			
		} else {
			if(!bank_number.matches("[0-9]{1,10}")) {
				valid = false;
				errmsg.add("����ԍ��͔��p����10�����ȓ��œ�͂��ĉ������B");
			}
		}
		/* branch_code Validation */
		if(StringUtils.isEmpty(branch_code)) {
			valid = false;
			errmsg.add("�x�X�ԍ����͂��Ă��������B");
		} else {
			if(!branch_code.matches("[0-9]{3}")) {
				valid = false;
				errmsg.add("�x�X�ԍ��͔��p����3�����ȓ��œ�͂��ĉ������B");				
			}
		}
		/* bank_persons Validation */
		if(StringUtils.isEmpty(bank_persons)) {
			valid = false;
			errmsg.add("������`�l���͂��Ă��������B");			
		} else {
			if(bank_persons.length() > 20) {
				valid = false;
				errmsg.add("������`�l��20�����ȓ��œ�͂��Ă��������B");				
			}
		}
		/* bank_name Validation */
		if(StringUtils.isEmpty(bank_name)) {
			valid = false;
			errmsg.add("��s����I�����Ă��������B");				
		}
		
		return valid;
	}
	/**
	 * getCreditAddValidation���\�b�h : �N���W�b�g�J�[�h�o�^�����ɑ΂���o���f�[�V����
	 * 
	 * @param card_number String : �N���W�b�g�J�[�h�ԍ�
	 * @param limit_date String : �L����
	 * @param card_company : �N���W�b�g�J�[�h��� 
	 * @param sec_code : �Z�L�����e�B�R�[�h
	 * @param card_persons : �J�[�h���`�l
	 * @return valid boolean : �o���f�[�V��������
	 */
	public boolean getCreditAddValidation(String card_number, String limit_date, String card_company,
			String sec_code, String card_persons) {
		// �G���[���b�Z�[�W���X�g����
		this.errmsg = new ArrayList<String>();
		// �o���f�[�V�������菉��
		this.valid = true;
		
		/* card_number Validation */
		if(StringUtils.isEmpty(card_number)) {
			valid = false;
			errmsg.add("�N���W�b�g�J�[�h�ԍ����͂��Ă��������B");
		} else {
			if(!card_number.matches("[0-9]{16}")) {
				valid = false;
				errmsg.add("�N���W�b�g�J�[�h�ԍ��͔��p����16�����œ�͂��ĉ������B");
			}
		}
		/* limit_date Validation */
		if(StringUtils.isEmpty(limit_date)) {
			valid = false;
			errmsg.add("�L������I�����Ă��������B");
		} else {
			if(!card_number.matches("[0-9]{4}-{1}[0-9]{2}")) {
				valid = false;
				errmsg.add("�L�����̌`��������������܂���B");
			}
		}
		/*�@card_company�@*/
		if(StringUtils.isEmpty(card_company)) {
			valid = false;
			errmsg.add("�N���W�b�g�J�[�h��Ђ��I������Ă��܂���B");
		}
		/* sec_code Validation */
		if(StringUtils.isEmpty(sec_code)) {
			valid = false;
			errmsg.add("�Z�L�����e�B�R�[�h����͂���Ă��܂���B");
		} else {
			if(!card_number.matches("[0-9]{3}")) {
				errmsg.add("�Z�L�����e�B�R�[�h�͔��p����3�����œ�͂��ĉ������B");
			}
		}
		/* card_persons Validation */
		if(StringUtils.isEmpty(card_persons)) {
			valid = false;
			errmsg.add("�J�[�h���`�l���͂��Ă��������B");
		} else {
			if(!card_number.matches("[A-Z]+ [A-Z]+")) {
				errmsg.add("�J�[�h���`�l�̌`�����Ԉ���Ă��܂��B");
			}
		}
		
		return valid;
	}
	/* 1/25 �r�� */
	public boolean getPostMusicValidation(String product_name, String price) {
		// �G���[���b�Z�[�W���X�g����
		this.errmsg = new ArrayList<String>();
		// �o���f�[�V�������菉��
		this.valid = true;
		
		/* product_name Validation */
		if(StringUtils.isEmpty(product_name)) {
			valid = false;
			errmsg.add("�y�Ȗ����͂��Ă��������B");
		} else {
			if(product_name.length() > 20) {
				errmsg.add("�y�Ȗ���20�����ȓ��œ�͂��Ă��������B");
			}
		}
		/* price Validation */
		if(StringUtils.isEmpty(price)) {
			valid = false;
			errmsg.add("���i���͂��Ă��������B");
		} else {
			if(!price.matches("[0-9]{1,6}")) {
				errmsg.add("���i�͔��p����6�����ȓ��œ�͂��ĉ������B");
			}
		}
		
		return valid;
	}
}
