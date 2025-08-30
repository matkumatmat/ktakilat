package com.ktakilat.cbase.datacollect;

import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;

public final class KtaCollect {
    public static void OTP_verification_page_click_resend(String str) {
        ba.z("scene", str, "OTP_verification_page_click_resend");
    }

    public static void OTP_verification_page_click_switch(String str, String str2) {
        ba.A("scene", str, FirebaseAnalytics.Param.METHOD, str2, "OTP_verification_page_click_switch");
    }

    public static void n_app_exit_to_the_background() {
        ba.y("n_app_exit_to_the_background");
    }

    public static void n_app_log_in() {
        ba.y("n_app_log_in");
    }

    public static void n_app_log_out() {
        ba.y("n_app_log_out");
    }

    public static void n_app_start_up() {
        ba.y("n_app_start_up");
    }

    public static void n_app_wake_from_the_background() {
        ba.y("n_app_wake_from_the_background");
    }

    public static void n_bankcard_clc_back() {
        ba.y("n_bankcard_clc_back");
    }

    public static void n_bankcard_clc_bank() {
        ba.y("n_bankcard_clc_bank");
    }

    public static void n_bankcard_clc_bank_num() {
        ba.y("n_bankcard_clc_bank_num");
    }

    public static void n_bankcard_clc_confirm_num() {
        ba.y("n_bankcard_clc_confirm_num");
    }

    public static void n_bankcard_clc_holder_name() {
        ba.y("n_bankcard_clc_holder_name");
    }

    public static void n_bankcard_clc_submit(String str) {
        ba.z("type", str, "n_bankcard_clc_submit");
    }

    public static void n_bankcard_exposure() {
        ba.y("n_bankcard_exposure");
    }

    public static void n_bankcard_submit_data_fail(String str) {
        ba.z(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, "n_bankcard_submit_data_fail");
    }

    public static void n_bankcard_submit_data_success() {
        ba.y("n_bankcard_submit_data_success");
    }

    public static void n_certification_clc_commit(String str) {
        ba.z("type", str, "n_certification_clc_commit");
    }

    public static void n_certification_clc_item(String str, String str2) {
        ba.A(FirebaseAnalytics.Param.ITEM_NAME, str, "status", str2, "n_certification_clc_item");
    }

    public static void n_certification_exposure(String str) {
        ba.z("forwardpage", str, "n_certification_exposure");
    }

    public static void n_change_pho_ektp_pop_clc_close() {
        ba.y("n_change_pho_ektp_pop_clc_close");
    }

    public static void n_change_pho_ektp_pop_exposure() {
        ba.y("n_change_pho_ektp_pop_exposure");
    }

    public static void n_change_pho_ektp_pop_type_ektp() {
        ba.y("n_change_pho_ektp_pop_type_ektp");
    }

    public static void n_change_pho_ektp_pop_verify_fail(String str) {
        ba.z("value", str, "n_change_pho_ektp_pop_verify_fail");
    }

    public static void n_change_pho_ektp_verify_success() {
        ba.y("n_change_pho_ektp_verify_success");
    }

    public static void n_change_pho_pwd_page_clc_con() {
        ba.y("n_change_pho_pwd_page_clc_con");
    }

    public static void n_change_pho_pwd_page_exp() {
        ba.y("n_change_pho_pwd_page_exp");
    }

    public static void n_change_pho_pwd_page_type_pwd() {
        ba.y("n_change_pho_pwd_page_type_pwd");
    }

    public static void n_change_pho_type_otp() {
        ba.y("n_change_pho_type_otp");
    }

    public static void n_change_pho_type_otp_clc_con(String str) {
        ba.z("result", str, "n_change_pho_type_otp_clc_con");
    }

    public static void n_change_pho_type_otp_clc_resend() {
        ba.y("n_change_pho_type_otp_clc_resend");
    }

    public static void n_change_pho_type_otp_page_exp() {
        ba.y("n_change_pho_type_otp_page_exp");
    }

    public static void n_change_pho_type_otp_sms_auto() {
        ba.y("n_change_pho_type_otp_sms_auto");
    }

    public static void n_change_pho_update_clc_continue(String str, String str2) {
        ba.A("result", str, "value", str2, "n_change_pho_update_clc_continue");
    }

    public static void n_change_pho_update_pho_clc_back() {
        ba.y("n_change_pho_update_pho_clc_back");
    }

    public static void n_change_pho_update_pho_clc_type() {
        ba.y("n_change_pho_update_pho_clc_type");
    }

    public static void n_change_pho_update_pho_exp() {
        ba.y("n_change_pho_update_pho_exp");
    }

    public static void n_change_phone_type_otp() {
        ba.y("n_change_phone_type_otp");
    }

    public static void n_change_phone_type_otp_clc_continue() {
        ba.y("n_change_phone_type_otp_clc_continue");
    }

    public static void n_change_phone_type_otp_clc_resend() {
        ba.y("n_change_phone_type_otp_clc_resend");
    }

    public static void n_change_phone_type_otp_page_exposure() {
        ba.y("n_change_phone_type_otp_page_exposure");
    }

    public static void n_change_phone_type_otp_sms_auto() {
        ba.y("n_change_phone_type_otp_sms_auto");
    }

    public static void n_change_phone_update_clc_continue(String str, String str2) {
        ba.A("result", str, "value", str2, "n_change_phone_update_clc_continue");
    }

    public static void n_change_phone_update_phone_clc_back() {
        ba.y("n_change_phone_update_phone_clc_back");
    }

    public static void n_change_phone_update_phone_clc_type() {
        ba.y("n_change_phone_update_phone_clc_type");
    }

    public static void n_change_phone_update_phone_exposure() {
        ba.y("n_change_phone_update_phone_exposure");
    }

    public static void n_city_picker_clc_back() {
        ba.y("n_city_picker_clc_back");
    }

    public static void n_city_picker_clc_item(String str, String str2) {
        ba.A("type", str, FirebaseAnalytics.Param.CONTENT, str2, "n_city_picker_clc_item");
    }

    public static void n_city_picker_exposure() {
        ba.y("n_city_picker_exposure");
    }

    public static void n_company_search_clc_confirm() {
        ba.y("n_company_search_clc_confirm");
    }

    public static void n_company_search_clc_type() {
        ba.y("n_company_search_clc_type");
    }

    public static void n_company_search_exposure() {
        ba.y("n_company_search_exposure");
    }

    public static void n_confirm_exit_pop_clc_cancel() {
        ba.y("n_confirm_exit_pop_clc_cancel");
    }

    public static void n_confirm_exit_pop_clc_confirm() {
        ba.y("n_confirm_exit_pop_clc_confirm");
    }

    public static void n_confirm_exit_pop_exposure() {
        ba.y("n_confirm_exit_pop_exposure");
    }

    public static void n_confirm_repay_clc_back() {
        ba.y("n_confirm_repay_clc_back");
    }

    public static void n_confirm_repay_clc_cancel_item(String str) {
        ba.z("expect_no", str, "n_confirm_repay_clc_cancel_item");
    }

    public static void n_confirm_repay_clc_choose_all() {
        ba.y("n_confirm_repay_clc_choose_all");
    }

    public static void n_confirm_repay_clc_choose_item(String str) {
        ba.z("expect_no", str, "n_confirm_repay_clc_choose_item");
    }

    public static void n_confirm_repay_exposure(String str) {
        ba.z("exposure_id", str, "n_confirm_repay_exposure");
    }

    public static void n_contact_clc_back() {
        ba.y("n_contact_clc_back");
    }

    public static void n_contact_clc_ec1_fixed_phone() {
        ba.y("n_contact_clc_ec1_fixed_phone");
    }

    public static void n_contact_clc_ec1_name() {
        ba.y("n_contact_clc_ec1_name");
    }

    public static void n_contact_clc_ec1_phone() {
        ba.y("n_contact_clc_ec1_phone");
    }

    public static void n_contact_clc_ec2_name() {
        ba.y("n_contact_clc_ec2_name");
    }

    public static void n_contact_clc_ec2_phone() {
        ba.y("n_contact_clc_ec2_phone");
    }

    public static void n_contact_clc_ec2_relationship() {
        ba.y("n_contact_clc_ec2_relationship");
    }

    public static void n_contact_clc_submit(String str) {
        ba.z("type", str, "n_contact_clc_submit");
    }

    public static void n_contact_exposure() {
        ba.y("n_contact_exposure");
    }

    public static void n_contact_submit_data_fail(String str) {
        ba.z(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, "n_contact_submit_data_fail");
    }

    public static void n_contact_submit_data_success() {
        ba.y("n_contact_submit_data_success");
    }

    public static void n_coupon_clc_back() {
        ba.y("n_coupon_clc_back");
    }

    public static void n_coupon_clc_use() {
        ba.y("n_coupon_clc_use");
    }

    public static void n_coupon_exposure() {
        ba.y("n_coupon_exposure");
    }

    public static void n_credit_score_clc_item(String str) {
        ba.z("service_type", str, "n_credit_score_clc_item");
    }

    public static void n_credit_score_commit_item(String str, String str2) {
        ba.A("service_type", str, "check_status", str2, "n_credit_score_commit_item");
    }

    public static void n_credit_score_exposure() {
        ba.y("n_credit_score_exposure");
    }

    public static void n_data_transfer_pop_clc_confirm() {
        ba.y("n_data_transfer_pop_clc_confirm");
    }

    public static void n_data_transfer_pop_exposure() {
        ba.y("n_data_transfer_pop_exposure");
    }

    public static void n_disclosure_pop_clc_ok() {
        ba.y("n_disclosure_pop_clc_ok");
    }

    public static void n_disclosure_pop_clc_reject() {
        ba.y("n_disclosure_pop_clc_reject");
    }

    public static void n_disclosure_pop_exposure() {
        ba.y("n_disclosure_pop_exposure");
    }

    public static void n_ektp_page_camera_init(String str) {
        ba.z("result", str, "n_ektp_page_camera_init");
    }

    public static void n_ektp_page_clc_back() {
        ba.y("n_ektp_page_clc_back");
    }

    public static void n_ektp_page_clc_cancel() {
        ba.y("n_ektp_page_clc_cancel");
    }

    public static void n_ektp_page_clc_confirm() {
        ba.y("n_ektp_page_clc_confirm");
    }

    public static void n_ektp_page_clc_shoot() {
        ba.y("n_ektp_page_clc_shoot");
    }

    public static void n_ektp_page_error(String str) {
        ba.z("msg", str, "n_ektp_page_error");
    }

    public static void n_ektp_page_exposure() {
        ba.y("n_ektp_page_exposure");
    }

    public static void n_ektp_page_img_call(String str, String str2) {
        ba.A("width", str, "height", str2, "n_ektp_page_img_call");
    }

    public static void n_ektp_repeat_phone_pop_clc_con() {
        ba.y("n_ektp_repeat_phone_pop_clc_con");
    }

    public static void n_ektp_repeat_phone_pop_clc_quit() {
        ba.y("n_ektp_repeat_phone_pop_clc_quit");
    }

    public static void n_ektp_repeat_phone_pop_type_phone() {
        ba.y("n_ektp_repeat_phone_pop_type_phone");
    }

    public static void n_ektp_repeat_phone_pop_type_pwd() {
        ba.y("n_ektp_repeat_phone_pop_type_pwd");
    }

    public static void n_ektp_repeat_pop_clc_change() {
        ba.y("n_ektp_repeat_pop_clc_change");
    }

    public static void n_ektp_repeat_pop_clc_continue() {
        ba.y("n_ektp_repeat_pop_clc_continue");
    }

    public static void n_ektp_repeat_pop_exposure(String str) {
        ba.z("ektpnumber", str, "n_ektp_repeat_pop_exposure");
    }

    public static void n_ektp_vefiry_phone_pop_exposure() {
        ba.y("n_ektp_vefiry_phone_pop_exposure");
    }

    public static void n_ektp_verifi_pop_clc_back() {
        ba.y("n_ektp_verifi_pop_clc_back");
    }

    public static void n_ektp_verifi_pop_clc_continue() {
        ba.y("n_ektp_verifi_pop_clc_continue");
    }

    public static void n_ektp_verifi_pop_exposure(String str) {
        ba.z("ektpnumber", str, "n_ektp_verifi_pop_exposure");
    }

    public static void n_face_detect_exposure(String str) {
        ba.z("scence", str, "n_face_detect_exposure");
    }

    public static void n_face_detect_result(String str) {
        ba.z("result", str, "n_face_detect_result");
    }

    public static void n_face_login_exposure(String str) {
        ba.z("scene", str, "n_face_login_exposure");
    }

    public static void n_face_login_fail(String str) {
        ba.z("errorCode", str, "n_face_login_fail");
    }

    public static void n_face_login_set_fail(String str) {
        ba.z("errorCode", str, "n_face_login_set_fail");
    }

    public static void n_face_login_set_suc() {
        ba.y("n_face_login_set_suc");
    }

    public static void n_face_login_suc() {
        ba.y("n_face_login_suc");
    }

    public static void n_face_result(String str) {
        ba.z("result", str, "n_face_result");
    }

    public static void n_face_type(String str) {
        ba.z("types", str, "n_face_type");
    }

    public static void n_face_upload_result(String str) {
        ba.z("result", str, "n_face_upload_result");
    }

    public static void n_face_verification_page_click(String str, String str2) {
        ba.A("scene", str, NativeProtocol.WEB_DIALOG_ACTION, str2, "n_face_verification_page_click");
    }

    public static void n_face_verification_page_exposure(String str) {
        ba.z("scene", str, "n_face_verification_page_exposure");
    }

    public static void n_face_verification_page_result(String str, String str2) {
        ba.A("scene", str, "result", str2, "n_face_verification_page_result");
    }

    public static void n_first_apply_clc_cancel_pd(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_first_apply_clc_cancel_pd", f);
    }

    public static void n_first_apply_clc_choose_pd(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_first_apply_clc_choose_pd", f);
    }

    public static void n_first_apply_clc_commit() {
        ba.y("n_first_apply_clc_commit");
    }

    public static void n_first_apply_clc_coupon() {
        ba.y("n_first_apply_clc_coupon");
    }

    public static void n_first_apply_clc_detail(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_first_apply_clc_detail", f);
    }

    public static void n_first_apply_clc_locked(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_first_apply_clc_locked", f);
    }

    public static void n_first_apply_clc_purpose() {
        ba.y("n_first_apply_clc_purpose");
    }

    public static void n_first_apply_clc_repay_plan(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_first_apply_clc_repay_plan", f);
    }

    public static void n_first_apply_clc_selected(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_first_apply_clc_selected", f);
    }

    public static void n_first_apply_exposure(String str) {
        ba.z("page_exposure_id", str, "n_first_apply_exposure");
    }

    public static void n_forget_password_clc_back(String str) {
        ba.z("forwardpage", str, "n_forget_password_clc_back");
    }

    public static void n_forget_password_clc_continue(String str) {
        ba.z("forwardpage", str, "n_forget_password_clc_continue");
    }

    public static void n_forget_password_exposure(String str) {
        ba.z("forwardpage", str, "n_forget_password_exposure");
    }

    public static void n_forget_pwd_clc_back() {
        ba.y("n_forget_pwd_clc_back");
    }

    public static void n_forget_pwd_clc_continue() {
        ba.y("n_forget_pwd_clc_continue");
    }

    public static void n_forget_pwd_clc_type() {
        ba.y("n_forget_pwd_clc_type");
    }

    public static void n_forget_pwd_exposure() {
        ba.y("n_forget_pwd_exposure");
    }

    public static void n_forget_pwd_otp_clc_back() {
        ba.y("n_forget_pwd_otp_clc_back");
    }

    public static void n_forget_pwd_otp_clc_commit(String str) {
        ba.z("type", str, "n_forget_pwd_otp_clc_commit");
    }

    public static void n_forget_pwd_otp_exposure(String str) {
        ba.z("forwardpage", str, "n_forget_pwd_otp_exposure");
    }

    public static void n_forget_pwd_otp_retry() {
        ba.y("n_forget_pwd_otp_retry");
    }

    public static void n_forget_pwd_otp_type() {
        ba.y("n_forget_pwd_otp_type");
    }

    public static void n_forget_pwd_reset_clc_back() {
        ba.y("n_forget_pwd_reset_clc_back");
    }

    public static void n_forget_pwd_reset_clc_commit() {
        ba.y("n_forget_pwd_reset_clc_commit");
    }

    public static void n_forget_pwd_reset_clc_pwd(String str) {
        ba.z("type", str, "n_forget_pwd_reset_clc_pwd");
    }

    public static void n_forget_pwd_reset_exposure() {
        ba.y("n_forget_pwd_reset_exposure");
    }

    public static void n_forgetpwd_ektp_popup_clc_close() {
        ba.y("n_forgetpwd_ektp_popup_clc_close");
    }

    public static void n_forgetpwd_ektp_popup_exposure() {
        ba.y("n_forgetpwd_ektp_popup_exposure");
    }

    public static void n_forgetpwd_ektp_popup_type_ektp() {
        ba.y("n_forgetpwd_ektp_popup_type_ektp");
    }

    public static void n_forgetpwd_ektp_popup_verify_fail(String str) {
        ba.z("value", str, "n_forgetpwd_ektp_popup_verify_fail");
    }

    public static void n_forgetpwd_ektp_popup_verify_suc() {
        ba.y("n_forgetpwd_ektp_popup_verify_suc");
    }

    public static void n_forgetpwd_otp_sms_auto(String str) {
        ba.z("forwardpage", str, "n_forgetpwd_otp_sms_auto");
    }

    public static void n_get_gaid_popup_clc_close() {
        ba.y("n_get_gaid_popup_clc_close");
    }

    public static void n_get_gaid_popup_clc_setting() {
        ba.y("n_get_gaid_popup_clc_setting");
    }

    public static void n_get_gaid_popup_exposure() {
        ba.y("n_get_gaid_popup_exposure");
    }

    public static void n_google_address_clc_address() {
        ba.y("n_google_address_clc_address");
    }

    public static void n_google_address_clc_back() {
        ba.y("n_google_address_clc_back");
    }

    public static void n_google_address_clc_send() {
        ba.y("n_google_address_clc_send");
    }

    public static void n_google_address_exposure(String str) {
        ba.z("whichpage", str, "n_google_address_exposure");
    }

    public static void n_home_b_clc_floating(String str) {
        ba.z("floating_icon_id", str, "n_home_b_clc_floating");
    }

    public static void n_home_b_clc_op_icon(String str) {
        ba.z("op_icon_id", str, "n_home_b_clc_op_icon");
    }

    public static void n_home_b_clc_product(String str, String str2) {
        ba.A("product_id", str, "scene_id", str2, "n_home_b_clc_product");
    }

    public static void n_home_b_duration(String str) {
        ba.z("time", str, "n_home_b_duration");
    }

    public static void n_home_b_floating_exposure(String str) {
        ba.z("floating_icon_id", str, "n_home_b_floating_exposure");
    }

    public static void n_home_b_op_icon_exposure(String str) {
        ba.z("op_icon_id", str, "n_home_b_op_icon_exposure");
    }

    public static void n_home_b_scene_exposure(String str, String str2, String str3) {
        Bundle f = ba.f("scene_id", str, "product_id", str2);
        f.putString("product_rank", str3);
        DataCollectManager.b("n_home_b_scene_exposure", f);
    }

    public static void n_home_b_show_exposure(String str) {
        ba.z("page_exposure_id", str, "n_home_b_show_exposure");
    }

    public static void n_home_clc_banner(String str) {
        ba.z("banner_id", str, "n_home_clc_banner");
    }

    public static void n_home_clc_cancel_pd(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_home_clc_cancel_pd", f);
    }

    public static void n_home_clc_choose_pd(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_home_clc_choose_pd", f);
    }

    public static void n_home_clc_detail(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_home_clc_detail", f);
    }

    public static void n_home_clc_locked(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_home_clc_locked", f);
    }

    public static void n_home_clc_message() {
        ba.y("n_home_clc_message");
    }

    public static void n_home_clc_new_user_bg_image() {
        ba.y("n_home_clc_new_user_bg_image");
    }

    public static void n_home_clc_repay_plan(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_home_clc_repay_plan", f);
    }

    public static void n_home_clc_selected(String str, String str2, String str3) {
        Bundle f = ba.f("product_cd", str, "repay_method", str2);
        f.putString("page_exposure_id", str3);
        DataCollectManager.b("n_home_clc_selected", f);
    }

    public static void n_home_loan_exposure(String str) {
        ba.z("page_exposure_id", str, "n_home_loan_exposure");
    }

    public static void n_home_show_which(String str) {
        ba.z("whichpage", str, "n_home_show_which");
    }

    public static void n_identity_clc_back() {
        ba.y("n_identity_clc_back");
    }

    public static void n_identity_clc_face() {
        ba.y("n_identity_clc_face");
    }

    public static void n_identity_clc_front_face() {
        ba.y("n_identity_clc_front_face");
    }

    public static void n_identity_clc_ktp_num() {
        ba.y("n_identity_clc_ktp_num");
    }

    public static void n_identity_clc_ktp_num_et(String str) {
        ba.z(FirebaseAnalytics.Param.CONTENT, str, "n_identity_clc_ktp_num_et");
    }

    public static void n_identity_clc_name() {
        ba.y("n_identity_clc_name");
    }

    public static void n_identity_clc_name_et(String str) {
        ba.z(FirebaseAnalytics.Param.CONTENT, str, "n_identity_clc_name_et");
    }

    public static void n_identity_clc_side_face() {
        ba.y("n_identity_clc_side_face");
    }

    public static void n_identity_clc_submit() {
        ba.y("n_identity_clc_submit");
    }

    public static void n_identity_clc_upload_ektp() {
        ba.y("n_identity_clc_upload_ektp");
    }

    public static void n_identity_ektp_result(String str) {
        ba.z("result", str, "n_identity_ektp_result");
    }

    public static void n_identity_face_result(String str) {
        ba.z("result", str, "n_identity_face_result");
    }

    public static void n_identity_front_face_result(String str) {
        ba.z("result", str, "n_identity_front_face_result");
    }

    public static void n_identity_side_face_result(String str) {
        ba.z("result", str, "n_identity_side_face_result");
    }

    public static void n_identity_submit_data_fail(String str) {
        ba.z(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, "n_identity_submit_data_fail");
    }

    public static void n_identity_submit_data_success() {
        ba.y("n_identity_submit_data_success");
    }

    public static void n_identity_view_exposure() {
        ba.y("n_identity_view_exposure");
    }

    public static void n_im_init_result(String str, String str2) {
        ba.A("resul", str, "error", str2, "n_im_init_result");
    }

    public static void n_install_bill_clc_coupon(String str) {
        ba.z("exposure_id", str, "n_install_bill_clc_coupon");
    }

    public static void n_install_bill_clc_detail(String str, String str2) {
        ba.A("exposure_id", str, "periode", str2, "n_install_bill_clc_detail");
    }

    public static void n_install_bill_clc_prepayment(String str) {
        ba.z("exposure_id", str, "n_install_bill_clc_prepayment");
    }

    public static void n_install_bill_clc_repay(String str) {
        ba.z("exposure_id", str, "n_install_bill_clc_repay");
    }

    public static void n_install_bill_clc_view_more(String str) {
        ba.z("exposure_id", str, "n_install_bill_clc_view_more");
    }

    public static void n_install_bill_detail_clc_ok(String str) {
        ba.z("exposure_id", str, "n_install_bill_detail_clc_ok");
    }

    public static void n_install_bill_detail_pop_exposure(String str) {
        ba.z("exposure_id", str, "n_install_bill_detail_pop_exposure");
    }

    public static void n_install_bill_exposure(String str, String str2, String str3) {
        Bundle f = ba.f("status", str, "due_date", str2);
        f.putString("exposure_id", str3);
        DataCollectManager.b("n_install_bill_exposure", f);
    }

    public static void n_job_clc_area_code() {
        ba.y("n_job_clc_area_code");
    }

    public static void n_job_clc_back() {
        ba.y("n_job_clc_back");
    }

    public static void n_job_clc_company_name() {
        ba.y("n_job_clc_company_name");
    }

    public static void n_job_clc_income() {
        ba.y("n_job_clc_income");
    }

    public static void n_job_clc_industry() {
        ba.y("n_job_clc_industry");
    }

    public static void n_job_clc_office_number() {
        ba.y("n_job_clc_office_number");
    }

    public static void n_job_clc_payday() {
        ba.y("n_job_clc_payday");
    }

    public static void n_job_clc_submit(String str) {
        ba.z("type", str, "n_job_clc_submit");
    }

    public static void n_job_clc_type_email() {
        ba.y("n_job_clc_type_email");
    }

    public static void n_job_clc_work_address() {
        ba.y("n_job_clc_work_address");
    }

    public static void n_job_clc_work_city() {
        ba.y("n_job_clc_work_city");
    }

    public static void n_job_exposure() {
        ba.y("n_job_exposure");
    }

    public static void n_job_submit_data_fail(String str) {
        ba.z(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, "n_job_submit_data_fail");
    }

    public static void n_job_submit_data_success() {
        ba.y("n_job_submit_data_success");
    }

    public static void n_js_call_android(String str, String str2) {
        ba.A(FirebaseAnalytics.Param.METHOD, str, NativeProtocol.WEB_DIALOG_PARAMS, str2, "n_js_call_android");
    }

    public static void n_live_detection_error_pop_clc_cs() {
        ba.y("n_live_detection_error_pop_clc_cs");
    }

    public static void n_live_detection_error_pop_clc_retry() {
        ba.y("n_live_detection_error_pop_clc_retry");
    }

    public static void n_live_detection_error_pop_exposure() {
        ba.y("n_live_detection_error_pop_exposure");
    }

    public static void n_live_detection_init_error(String str) {
        ba.z("errorType", str, "n_live_detection_init_error");
    }

    public static void n_live_login_upload_fail(String str) {
        ba.z("errorCode", str, "n_live_login_upload_fail");
    }

    public static void n_live_login_upload_suc() {
        ba.y("n_live_login_upload_suc");
    }

    public static void n_live_page_camera_init_fail() {
        ba.y("n_live_page_camera_init_fail");
    }

    public static void n_live_set_upload_fail(String str) {
        ba.z("errorCode", str, "n_live_set_upload_fail");
    }

    public static void n_live_set_upload_suc() {
        ba.y("n_live_set_upload_suc");
    }

    public static void n_liveness_exposure() {
        ba.y("n_liveness_exposure");
    }

    public static void n_loan_contrat_pop_clc_cancel() {
        ba.y("n_loan_contrat_pop_clc_cancel");
    }

    public static void n_loan_contrat_pop_clc_confirm() {
        ba.y("n_loan_contrat_pop_clc_confirm");
    }

    public static void n_loan_contrat_pop_exposure() {
        ba.y("n_loan_contrat_pop_exposure");
    }

    public static void n_loan_record_clc_back() {
        ba.y("n_loan_record_clc_back");
    }

    public static void n_loan_record_clc_download() {
        ba.y("n_loan_record_clc_download");
    }

    public static void n_loan_record_exposure() {
        ba.y("n_loan_record_exposure");
    }

    public static void n_loan_success_exposure() {
        ba.y("n_loan_success_exposure");
    }

    public static void n_loan_success_exposure_clc_back() {
        ba.y("n_loan_success_exposure_clc_back");
    }

    public static void n_loan_success_exposure_clc_ok() {
        ba.y("n_loan_success_exposure_clc_ok");
    }

    public static void n_log_in_clc_back() {
        ba.y("n_log_in_clc_back");
    }

    public static void n_log_in_clc_forget_password() {
        ba.y("n_log_in_clc_forget_password");
    }

    public static void n_log_in_clc_log_in() {
        ba.y("n_log_in_clc_log_in");
    }

    public static void n_log_in_clc_password() {
        ba.y("n_log_in_clc_password");
    }

    public static void n_log_in_clc_phone() {
        ba.y("n_log_in_clc_phone");
    }

    public static void n_log_in_clc_privacy() {
        ba.y("n_log_in_clc_privacy");
    }

    public static void n_log_in_clc_register() {
        ba.y("n_log_in_clc_register");
    }

    public static void n_log_in_clc_term() {
        ba.y("n_log_in_clc_term");
    }

    public static void n_log_in_exposure(String str) {
        ba.z("forwardpage", str, "n_log_in_exposure");
    }

    public static void n_log_in_fail(String str) {
        ba.z(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, "n_log_in_fail");
    }

    public static void n_log_in_success() {
        ba.y("n_log_in_success");
    }

    public static void n_login_otp_clc_back() {
        ba.y("n_login_otp_clc_back");
    }

    public static void n_login_otp_clc_change_method() {
        ba.y("n_login_otp_clc_change_method");
    }

    public static void n_login_otp_clc_change_phone() {
        ba.y("n_login_otp_clc_change_phone");
    }

    public static void n_login_otp_clc_login() {
        ba.y("n_login_otp_clc_login");
    }

    public static void n_login_otp_clc_more() {
        ba.y("n_login_otp_clc_more");
    }

    public static void n_login_otp_clc_obtain_otp() {
        ba.y("n_login_otp_clc_obtain_otp");
    }

    public static void n_login_otp_clc_resend() {
        ba.y("n_login_otp_clc_resend");
    }

    public static void n_login_otp_clc_switch(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.METHOD, i);
        DataCollectManager.b("n_login_otp_clc_switch", bundle);
    }

    public static void n_login_otp_clc_switch_account() {
        ba.y("n_login_otp_clc_switch_account");
    }

    public static void n_login_otp_exposure(String str) {
        ba.z("showTip", str, "n_login_otp_exposure");
    }

    public static void n_login_otp_sms_auto() {
        ba.y("n_login_otp_sms_auto");
    }

    public static void n_login_otp_tybe_otp() {
        ba.y("n_login_otp_tybe_otp");
    }

    public static void n_login_page_clc_change_method(String str, String str2) {
        ba.A("current", str, "switchto", str2, "n_login_page_clc_change_method");
    }

    public static void n_login_page_clc_change_phone(String str) {
        ba.z(FirebaseAnalytics.Param.METHOD, str, "n_login_page_clc_change_phone");
    }

    public static void n_login_page_clc_forget_pwd(String str) {
        ba.z(FirebaseAnalytics.Param.METHOD, str, "n_login_page_clc_forget_pwd");
    }

    public static void n_login_page_clc_more(String str) {
        ba.z(FirebaseAnalytics.Param.METHOD, str, "n_login_page_clc_more");
    }

    public static void n_login_page_clc_switch_account(String str) {
        ba.z(FirebaseAnalytics.Param.METHOD, str, "n_login_page_clc_switch_account");
    }

    public static void n_login_page_exposure(String str, String str2) {
        ba.A("text", str, FirebaseAnalytics.Param.METHOD, str2, "n_login_page_exposure");
    }

    public static void n_login_page_result(String str, String str2, String str3) {
        Bundle f = ba.f(FirebaseAnalytics.Param.METHOD, str, "result", str2);
        f.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str3);
        DataCollectManager.b("n_login_page_result", f);
    }

    public static void n_login_password_clc_back() {
        ba.y("n_login_password_clc_back");
    }

    public static void n_login_password_clc_change_method() {
        ba.y("n_login_password_clc_change_method");
    }

    public static void n_login_password_clc_change_phone() {
        ba.y("n_login_password_clc_change_phone");
    }

    public static void n_login_password_clc_forget_pwd() {
        ba.y("n_login_password_clc_forget_pwd");
    }

    public static void n_login_password_clc_login() {
        ba.y("n_login_password_clc_login");
    }

    public static void n_login_password_clc_more() {
        ba.y("n_login_password_clc_more");
    }

    public static void n_login_password_clc_switch_account() {
        ba.y("n_login_password_clc_switch_account");
    }

    public static void n_login_password_exposure(String str) {
        ba.z("showTip", str, "n_login_password_exposure");
    }

    public static void n_login_password_type_password() {
        ba.y("n_login_password_type_password");
    }

    public static void n_message_clc_back() {
        ba.y("n_message_clc_back");
    }

    public static void n_message_exposure() {
        ba.y("n_message_exposure");
    }

    public static void n_mine_clc_about_us() {
        ba.y("n_mine_clc_about_us");
    }

    public static void n_mine_clc_coupon() {
        ba.y("n_mine_clc_coupon");
    }

    public static void n_mine_clc_head_image() {
        ba.y("n_mine_clc_head_image");
    }

    public static void n_mine_clc_help_center() {
        ba.y("n_mine_clc_help_center");
    }

    public static void n_mine_clc_loan_record() {
        ba.y("n_mine_clc_loan_record");
    }

    public static void n_mine_clc_online_service() {
        ba.y("n_mine_clc_online_service");
    }

    public static void n_mine_clc_setting() {
        ba.y("n_mine_clc_setting");
    }

    public static void n_mine_exposure() {
        ba.y("n_mine_exposure");
    }

    public static void n_ojk_disclaimer_pop_up(String str) {
        ba.z("click", str, "n_ojk_disclaimer_pop_up");
    }

    public static void n_ojk_warning_pop_clc_cancel() {
        ba.y("n_ojk_warning_pop_clc_cancel");
    }

    public static void n_ojk_warning_pop_clc_confirm() {
        ba.y("n_ojk_warning_pop_clc_confirm");
    }

    public static void n_ojk_warning_pop_exposure() {
        ba.y("n_ojk_warning_pop_exposure");
    }

    public static void n_otp_verification_page_click(String str, String str2) {
        ba.A("scene", str, NativeProtocol.WEB_DIALOG_ACTION, str2, "n_otp_verification_page_click");
    }

    public static void n_otp_verification_page_exposure(String str) {
        ba.z("scene", str, "n_otp_verification_page_exposure");
    }

    public static void n_otp_verification_page_result(String str, String str2) {
        ba.A("scene", str, "result", str2, "n_otp_verification_page_result");
    }

    public static void n_pattern_guide_clc_cancel() {
        ba.y("n_pattern_guide_clc_cancel");
    }

    public static void n_pattern_guide_clc_ok() {
        ba.y("n_pattern_guide_clc_ok");
    }

    public static void n_pattern_guide_exposure() {
        ba.y("n_pattern_guide_exposure");
    }

    public static void n_pattern_pwd_clc_back() {
        ba.y("n_pattern_pwd_clc_back");
    }

    public static void n_pattern_pwd_clc_skip() {
        ba.y("n_pattern_pwd_clc_skip");
    }

    public static void n_pattern_pwd_exposure(String str) {
        ba.z("scene", str, "n_pattern_pwd_exposure");
    }

    public static void n_pattern_pwd_pop1_clc_con() {
        ba.y("n_pattern_pwd_pop1_clc_con");
    }

    public static void n_pattern_pwd_pop1_clc_exit() {
        ba.y("n_pattern_pwd_pop1_clc_exit");
    }

    public static void n_pattern_pwd_pop1_exposure() {
        ba.y("n_pattern_pwd_pop1_exposure");
    }

    public static void n_pattern_pwd_result(String str, String str2) {
        ba.A("scene", str, "result", str2, "n_pattern_pwd_result");
    }

    public static void n_phone_judge_page_clc_continue() {
        ba.y("n_phone_judge_page_clc_continue");
    }

    public static void n_phone_judge_page_exposure() {
        ba.y("n_phone_judge_page_exposure");
    }

    public static void n_phone_judge_page_type_phone() {
        ba.y("n_phone_judge_page_type_phone");
    }

    public static void n_preview_expired_pop_clc_close() {
        ba.y("n_preview_expired_pop_clc_close");
    }

    public static void n_preview_expired_pop_clc_ok() {
        ba.y("n_preview_expired_pop_clc_ok");
    }

    public static void n_preview_expired_pop_exposure() {
        ba.y("n_preview_expired_pop_exposure");
    }

    public static void n_preview_exposure(String str) {
        ba.z("first_preview", str, "n_preview_exposure");
    }

    public static void n_preview_get_result_duration(String str) {
        ba.z("time", str, "n_preview_get_result_duration");
    }

    public static void n_preview_result_runtime() {
        ba.y("n_preview_result_runtime");
    }

    public static void n_preview_success_pop_clc_close() {
        ba.y("n_preview_success_pop_clc_close");
    }

    public static void n_preview_success_pop_clc_ok() {
        ba.y("n_preview_success_pop_clc_ok");
    }

    public static void n_preview_success_pop_exposure() {
        ba.y("n_preview_success_pop_exposure");
    }

    public static void n_product_details_clc_back(String str, String str2, String str3) {
        Bundle f = ba.f("product_id", str, "scene_id", str2);
        f.putString("last_page", str3);
        DataCollectManager.b("n_product_details_clc_back", f);
    }

    public static void n_product_details_clc_download(String str, String str2, String str3) {
        Bundle f = ba.f("product_id", str, "scene_id", str2);
        f.putString("last_page", str3);
        DataCollectManager.b("n_product_details_clc_download", f);
    }

    public static void n_product_details_duration(String str, String str2, String str3, String str4) {
        Bundle f = ba.f(TypedValues.TransitionType.S_DURATION, str, "product_id", str2);
        f.putString("scene_id", str3);
        f.putString("last_page", str4);
        DataCollectManager.b("n_product_details_duration", f);
    }

    public static void n_product_details_exposure(String str, String str2, String str3) {
        Bundle f = ba.f("product_id", str, "scene_id", str2);
        f.putString("last_page", str3);
        DataCollectManager.b("n_product_details_exposure", f);
    }

    public static void n_profile_clc_back() {
        ba.y("n_profile_clc_back");
    }

    public static void n_profile_clc_google_address() {
        ba.y("n_profile_clc_google_address");
    }

    public static void n_profile_clc_live_address() {
        ba.y("n_profile_clc_live_address");
    }

    public static void n_profile_clc_live_city() {
        ba.y("n_profile_clc_live_city");
    }

    public static void n_profile_clc_live_time() {
        ba.y("n_profile_clc_live_time");
    }

    public static void n_profile_clc_live_type() {
        ba.y("n_profile_clc_live_type");
    }

    public static void n_profile_clc_marital_status() {
        ba.y("n_profile_clc_marital_status");
    }

    public static void n_profile_clc_submit(String str) {
        ba.z("type", str, "n_profile_clc_submit");
    }

    public static void n_profile_clc_whatsapp() {
        ba.y("n_profile_clc_whatsapp");
    }

    public static void n_profile_exposure() {
        ba.y("n_profile_exposure");
    }

    public static void n_profile_submit_data_fail(String str) {
        ba.z(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, "n_profile_submit_data_fail");
    }

    public static void n_profile_submit_data_success() {
        ba.y("n_profile_submit_data_success");
    }

    public static void n_pwd_manage_clc_face_switch(String str) {
        ba.z("status", str, "n_pwd_manage_clc_face_switch");
    }

    public static void n_pwd_manage_clc_forgetpwd() {
        ba.y("n_pwd_manage_clc_forgetpwd");
    }

    public static void n_pwd_manage_clc_set_gesture() {
        ba.y("n_pwd_manage_clc_set_gesture");
    }

    public static void n_pwd_manage_exposure() {
        ba.y("n_pwd_manage_exposure");
    }

    public static void n_rate_for_gp_clc_cancel() {
        ba.y("n_rate_for_gp_clc_cancel");
    }

    public static void n_rate_for_gp_clc_continue() {
        ba.y("n_rate_for_gp_clc_continue");
    }

    public static void n_rate_for_gp_exposure() {
        ba.y("n_rate_for_gp_exposure");
    }

    public static void n_re_verfiry_phone_clc_back() {
        ba.y("n_re_verfiry_phone_clc_back");
    }

    public static void n_re_verfiry_phone_exposure(String str, String str2) {
        ba.A("type", str, "fromPage", str2, "n_re_verfiry_phone_exposure");
    }

    public static void n_re_verfiry_phone_get_otp() {
        ba.y("n_re_verfiry_phone_get_otp");
    }

    public static void n_re_verfiry_phone_modify_phone() {
        ba.y("n_re_verfiry_phone_modify_phone");
    }

    public static void n_register_clc_back() {
        ba.y("n_register_clc_back");
    }

    public static void n_register_clc_disclaimer() {
        ba.y("n_register_clc_disclaimer");
    }

    public static void n_register_clc_get_otp(String str) {
        ba.z("times", str, "n_register_clc_get_otp");
    }

    public static void n_register_clc_log_in() {
        ba.y("n_register_clc_log_in");
    }

    public static void n_register_clc_otp() {
        ba.y("n_register_clc_otp");
    }

    public static void n_register_clc_phone() {
        ba.y("n_register_clc_phone");
    }

    public static void n_register_clc_privacy() {
        ba.y("n_register_clc_privacy");
    }

    public static void n_register_clc_protocol_box() {
        ba.y("n_register_clc_protocol_box");
    }

    public static void n_register_clc_reg_f_cod(String str) {
        ba.z(PlaceFields.PHONE, str, "n_register_clc_reg_f_cod");
    }

    public static void n_register_clc_reg_f_pho() {
        ba.y("n_register_clc_reg_f_pho");
    }

    public static void n_register_clc_reg_f_pri() {
        ba.y("n_register_clc_reg_f_pri");
    }

    public static void n_register_clc_register() {
        ba.y("n_register_clc_register");
    }

    public static void n_register_clc_sms_auto() {
        ba.y("n_register_clc_sms_auto");
    }

    public static void n_register_clc_sms_f(String str) {
        ba.z(PlaceFields.PHONE, str, "n_register_clc_sms_f");
    }

    public static void n_register_clc_term() {
        ba.y("n_register_clc_term");
    }

    public static void n_register_exposure(String str) {
        ba.z("forwardpage", str, "n_register_exposure");
    }

    public static void n_register_otp_page_clc_back() {
        ba.y("n_register_otp_page_clc_back");
    }

    public static void n_register_otp_page_clc_continue() {
        ba.y("n_register_otp_page_clc_continue");
    }

    public static void n_register_otp_page_clc_resend() {
        ba.y("n_register_otp_page_clc_resend");
    }

    public static void n_register_otp_page_clc_switch(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.METHOD, i);
        DataCollectManager.b("n_register_otp_page_clc_switch", bundle);
    }

    public static void n_register_otp_page_exposure() {
        ba.y("n_register_otp_page_exposure");
    }

    public static void n_register_otp_page_sms_auto() {
        ba.y("n_register_otp_page_sms_auto");
    }

    public static void n_register_otp_page_type_otp() {
        ba.y("n_register_otp_page_type_otp");
    }

    public static void n_register_verify_failed() {
        ba.y("n_register_verify_failed");
    }

    public static void n_register_verify_success() {
        ba.y("n_register_verify_success");
    }

    public static void n_renewal_loan_clc_commit() {
        ba.y("n_renewal_loan_clc_commit");
    }

    public static void n_renewal_loan_clc_coupon() {
        ba.y("n_renewal_loan_clc_coupon");
    }

    public static void n_renewal_loan_clc_purpose() {
        ba.y("n_renewal_loan_clc_purpose");
    }

    public static void n_repay_guidement_clc_back() {
        ba.y("n_repay_guidement_clc_back");
    }

    public static void n_repay_guidement_clc_modify_method() {
        ba.y("n_repay_guidement_clc_modify_method");
    }

    public static void n_repay_guidement_clc_paid() {
        ba.y("n_repay_guidement_clc_paid");
    }

    public static void n_repay_guidement_exposure(String str) {
        ba.z("forwardpage", str, "n_repay_guidement_exposure");
    }

    public static void n_repay_method_choose_bank() {
        ba.y("n_repay_method_choose_bank");
    }

    public static void n_repay_method_choose_minimarket() {
        ba.y("n_repay_method_choose_minimarket");
    }

    public static void n_repay_method_clc_confirm() {
        ba.y("n_repay_method_clc_confirm");
    }

    public static void n_repay_method_exposure(String str) {
        ba.z("whichpage", str, "n_repay_method_exposure");
    }

    public static void n_repeat_vefiry_suc_pop_clc_ok() {
        ba.y("n_repeat_vefiry_suc_pop_clc_ok");
    }

    public static void n_repeat_vefiry_suc_pop_exposure() {
        ba.y("n_repeat_vefiry_suc_pop_exposure");
    }

    public static void n_request_GPS(String str) {
        ba.z("bussiness", str, "n_request_GPS");
    }

    public static void n_request_GPS_ready(String str) {
        ba.z("bussiness", str, "n_request_GPS_ready");
    }

    public static void n_request_GPS_result(String str, String str2) {
        ba.A("bussiness", str, "result", str2, "n_request_GPS_result");
    }

    public static void n_request_permission(String str, String str2) {
        ba.A("permission", str, "status", str2, "n_request_permission");
    }

    public static void n_retain_certification_pop_clc_back() {
        ba.y("n_retain_certification_pop_clc_back");
    }

    public static void n_retain_certification_pop_clc_con() {
        ba.y("n_retain_certification_pop_clc_con");
    }

    public static void n_retain_certification_pop_exposure(String str) {
        ba.z("tag", str, "n_retain_certification_pop_exposure");
    }

    public static void n_safe_auth_otp_select_popup_cancel(String str) {
        ba.z("scene", str, "n_safe_auth_otp_select_popup_cancel");
    }

    public static void n_safe_auth_otp_select_popup_exposure(String str) {
        ba.z("scene", str, "n_safe_auth_otp_select_popup_exposure");
    }

    public static void n_safe_auth_otp_select_popup_selected(String str, String str2) {
        ba.A("scene", str, FirebaseAnalytics.Param.METHOD, str2, "n_safe_auth_otp_select_popup_selected");
    }

    public static void n_set_password_clc_input() {
        ba.y("n_set_password_clc_input");
    }

    public static void n_set_password_clc_submit() {
        ba.y("n_set_password_clc_submit");
    }

    public static void n_set_password_exposure() {
        ba.y("n_set_password_exposure");
    }

    public static void n_setting_clc_back() {
        ba.y("n_setting_clc_back");
    }

    public static void n_setting_clc_exit() {
        ba.y("n_setting_clc_exit");
    }

    public static void n_setting_clc_forget_pwd() {
        ba.y("n_setting_clc_forget_pwd");
    }

    public static void n_setting_clc_modify_phone() {
        ba.y("n_setting_clc_modify_phone");
    }

    public static void n_setting_clc_share() {
        ba.y("n_setting_clc_share");
    }

    public static void n_setting_exposure() {
        ba.y("n_setting_exposure");
    }

    public static void n_splash_clc_skip() {
        ba.y("n_splash_clc_skip");
    }

    public static void n_splash_exposure() {
        ba.y("n_splash_exposure");
    }

    public static void n_stay_time_preview(String str) {
        ba.z("time", str, "n_stay_time_preview");
    }

    public static void n_type_otp_sms_auto(String str) {
        ba.z("forwardpage", str, "n_type_otp_sms_auto");
    }

    public static void n_update_phone_clc_back() {
        ba.y("n_update_phone_clc_back");
    }

    public static void n_update_phone_clc_continue() {
        ba.y("n_update_phone_clc_continue");
    }

    public static void n_update_phone_clc_type() {
        ba.y("n_update_phone_clc_type");
    }

    public static void n_update_phone_exposure() {
        ba.y("n_update_phone_exposure");
    }

    public static void n_update_phone_otp_clc_commit() {
        ba.y("n_update_phone_otp_clc_commit");
    }

    public static void n_update_phone_otp_exposure() {
        ba.y("n_update_phone_otp_exposure");
    }

    public static void n_update_phone_otp_retry() {
        ba.y("n_update_phone_otp_retry");
    }

    public static void n_update_phone_otp_type() {
        ba.y("n_update_phone_otp_type");
    }

    public static void n_upload_pic_fail(String str, String str2) {
        ba.A("picType", str, "errorCode", str2, "n_upload_pic_fail");
    }

    public static void n_upload_pic_suc(String str) {
        ba.z("picType", str, "n_upload_pic_suc");
    }

    public static void n_verification_name_pop_clc_con() {
        ba.y("n_verification_name_pop_clc_con");
    }

    public static void n_verification_name_pop_exposure(String str) {
        ba.z("whichpage", str, "n_verification_name_pop_exposure");
    }

    public static void n_verify_pwd_l1_pop_clc_commit(String str) {
        ba.z(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, "n_verify_pwd_l1_pop_clc_commit");
    }

    public static void n_verify_pwd_l1_pop_exposure(String str, String str2) {
        ba.A("type", str, "forwardpage", str2, "n_verify_pwd_l1_pop_exposure");
    }

    public static void n_verify_pwd_l1_pop_type_pwd() {
        ba.y("n_verify_pwd_l1_pop_type_pwd");
    }

    public static void n_verify_pwd_pop_clc_commit(String str) {
        ba.z(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str, "n_verify_pwd_pop_clc_commit");
    }

    public static void n_verify_pwd_pop_exposure(String str) {
        ba.z("forwardpage", str, "n_verify_pwd_pop_exposure");
    }

    public static void n_verify_pwd_pop_type_bank_number() {
        ba.y("n_verify_pwd_pop_type_bank_number");
    }

    public static void n_verify_pwd_pop_type_pwd() {
        ba.y("n_verify_pwd_pop_type_pwd");
    }

    public static void n_login_otp_clc_resend(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.METHOD, i);
        DataCollectManager.b("n_login_otp_clc_resend", bundle);
    }

    public static void n_register_otp_page_clc_resend(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(FirebaseAnalytics.Param.METHOD, i);
        DataCollectManager.b("n_register_otp_page_clc_resend", bundle);
    }

    public static void n_face_result(String str, String str2, Long l, String str3) {
        Bundle c = e.c("result", str);
        if (str2 != null) {
            c.putString("prompt", str2);
        }
        if (str3 != null) {
            c.putString("id", str3);
        }
        c.putLong(TypedValues.TransitionType.S_DURATION, l.longValue());
        DataCollectManager.b("n_face_result", c);
    }
}
