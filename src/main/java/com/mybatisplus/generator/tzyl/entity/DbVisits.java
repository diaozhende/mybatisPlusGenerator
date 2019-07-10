package com.mybatisplus.generator.tzyl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author diaozhende
 * @since 2019-07-10
 */
@Data
@TableName("db_visits")

public class DbVisits  {

    private static final long serialVersionUID = 1L;

    @TableId("RECID")
    private String recid;

    @TableField("CREATOR")
    private String creator;

    @TableField("DIAGNOSISCHECKBODY")
    private String diagnosischeckbody;

    @TableField("DIAGNOSISCOMPLAINTS")
    private String diagnosiscomplaints;

    @TableField("DIAGNOSISDETAILS")
    private String diagnosisdetails;

    @TableField("DIAGNOSISHISTORY")
    private String diagnosishistory;

    @TableField("FIELD1")
    private String field1;

    @TableField("FIELD2")
    private String field2;

    @TableField("FIELD3")
    private String field3;

    @TableField("FIELD4")
    private String field4;

    @TableField("FIELD5")
    private String field5;

    @TableField("MEDICALSECURITYGUID")
    private String medicalsecurityguid;

    @TableField("MEMO")
    private String memo;

    @TableField("MODIFYUSER")
    private String modifyuser;

    @TableField("ORDERSGUID")
    private String ordersguid;

    @TableField("PATIENTBIRTHDAY")
    private String patientbirthday;

    @TableField("DIAGNOSISFILE")
    private String diagnosisfile;

    @TableField("PATIENTCONSUMTYPE")
    private String patientconsumtype;

    @TableField("PATIENTNAME")
    private String patientname;

    @TableField("PATIENTIDNUM")
    private String patientidnum;

    @TableField("PATIENTPERSIDENT")
    private String patientpersident;

    @TableField("PATIENTPLACE")
    private String patientplace;

    @TableField("PATIENTSEX")
    private String patientsex;

    @TableField("STARTFLAG")
    private String startflag;

    @TableField("VISITSDOCTOR")
    private String visitsdoctor;

    @TableField("VISITSGUID")
    private String visitsguid;

    @TableField("VISITSTIME")
    private LocalDateTime visitstime;

    @TableField("MODIFYTIME")
    private LocalDateTime modifytime;

    @TableField("CREATETIME")
    private LocalDateTime createtime;


}
