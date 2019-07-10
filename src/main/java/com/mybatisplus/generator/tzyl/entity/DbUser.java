package com.mybatisplus.generator.tzyl.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-07-10
 */
@Data
public class DbUser  {

    private static final long serialVersionUID = 1L;

    @TableId("RECID")
    private String recid;

    @TableField("CERTIFICATENO")
    private String certificateno;

    @TableField("CREATETIME")
    private LocalDateTime createtime;

    @TableField("CREATOR")
    private String creator;

    @TableField("EMAIL")
    private String email;

    @TableField("FIELD1")
    private String field1;

    @TableField("FIELD2")
    private String field2;

    @TableField("FIELD3")
    private String field3;

    @TableField("GUIDPROJECTS")
    private String guidprojects;

    @TableField("IDENTITYCARD")
    private String identitycard;

    @TableField("IMGHEAD")
    private String imghead;

    @TableField("LASTLOGINTIME")
    private LocalDateTime lastlogintime;

    @TableField("MEMO")
    private String memo;

    @TableField("MOBILE")
    private String mobile;

    @TableField("MODIFYTIME")
    private LocalDateTime modifytime;

    @TableField("MODIFYUSER")
    private String modifyuser;

    @TableField("ORGANISATION")
    private String organisation;

    @TableField("ORIGIN")
    private String origin;

    @TableField("PASSWORD")
    private String password;

    @TableField("SECRETARYOFFICE")
    private String secretaryoffice;

    @TableField("SEX")
    private String sex;

    @TableField("STARTFLAG")
    private String startflag;

    @TableField("USERID")
    private String userid;

    @TableField("USERIDENTITY")
    private String useridentity;

    @TableField("USERNAME")
    private String username;

    @TableField("USERROLE")
    private String userrole;


}
