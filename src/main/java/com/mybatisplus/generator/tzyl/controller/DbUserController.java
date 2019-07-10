package com.mybatisplus.generator.tzyl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mybatisplus.generator.tzyl.entity.DbUser;
import com.mybatisplus.generator.tzyl.service.impl.DbUserServiceImpl;
import com.mybatisplus.generator.tzyl.service.IDbUserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.ArrayList;
import com.dzd.utils.ResultCode;
import com.dzd.utils.ResultData;
/**
 * @author jobob
 * @since 2019-07-10
 */
@RestController
@RequestMapping("/DbUserApi")
public class DbUserController{

 @Autowired
 private IDbUserService service = new DbUserServiceImpl();

/**
 * @author jobob
 * @since 2019-07-10
 * @Description: //TODO 查询数据列表
 */
@RequestMapping(value="/list",method= RequestMethod.GET)
 public ResultData<List<DbUser>> list(){
    ResultData<List<DbUser>> resultData = new ResultData<List<DbUser>>();
    List<DbUser> List = new ArrayList<DbUser>();
     try {
          List = service.list();
           resultData.setCode(ResultCode.SUCCESS);
           resultData.setData(List);
           return resultData;
        } catch (Exception e) {
            e.printStackTrace();
            resultData.setCode(ResultCode.INTERNAL_SERVER_ERROR);
            resultData.setMessage(e.getMessage());
            return resultData;
        }
  }



    /**
     * @author jobob
     * @since 2019-07-10
     * @Description: //TODO 增加
     */
    @RequestMapping(value="/add",method= RequestMethod.POST)
     public ResultData<String> add(DbUser pojo){
        ResultData<String> resultData = new ResultData<String>();
        try {
            service.save(pojo);
            resultData.setCode(ResultCode.SUCCESS);
            return resultData;
        } catch (Exception e) {
            resultData.setCode(ResultCode.INTERNAL_SERVER_ERROR);
            resultData.setMessage(e.getMessage());
            return resultData;
        }
    }

    /**
     * @author jobob
     * @since 2019-07-10
     * @Description: //TODO 根据id查询信息
     */
    @RequestMapping(value="/selectOne",method= RequestMethod.GET)
     public ResultData<DbUser> selectOne(int id){
        ResultData<DbUser> resultData = new ResultData<DbUser>();
        DbUser pojo = new DbUser();
        try {
            pojo = service.getById(id);
            resultData.setCode(ResultCode.SUCCESS);
            resultData.setData(pojo);
            return resultData;
        } catch (Exception e) {
            resultData.setCode(ResultCode.INTERNAL_SERVER_ERROR);
            resultData.setMessage(e.getMessage());
            return resultData;
        }
    }

    /**
     * @author jobob
     * @since 2019-07-10
     * @Description: //TODO 修改
     */
    @RequestMapping(value="/update",method= RequestMethod.POST)
     public ResultData<String> update(DbUser pojo){
        ResultData<String> resultData = new ResultData<String>();
        try {
            QueryWrapper<DbUser> queryWrapper = new QueryWrapper<DbUser>();
            queryWrapper.eq("","");
            service.update(pojo,queryWrapper);
            resultData.setCode(ResultCode.SUCCESS);
            return resultData;
        } catch (Exception e) {
            resultData.setCode(ResultCode.INTERNAL_SERVER_ERROR);
            resultData.setMessage(e.getMessage());
            return resultData;
        }
    }

    /**
     * @author jobob
     * @since 2019-07-10
     * @Description: //TODO 删除
     */
    @RequestMapping(value="/delete",method= RequestMethod.GET)
     public ResultData<String> delete(int id){
        ResultData<String> resultData = new ResultData<String>();
        try {
            service.removeById(id);
            resultData.setCode(ResultCode.SUCCESS);
            return resultData;
        } catch (Exception e) {
            resultData.setCode(ResultCode.INTERNAL_SERVER_ERROR);
            resultData.setMessage(e.getMessage());
            return resultData;
        }
    }
}
