package com.mybatisplus.generator.tzyl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mybatisplus.generator.tzyl.entity.DbVisits;
import com.mybatisplus.generator.tzyl.service.impl.DbVisitsServiceImpl;
import com.mybatisplus.generator.tzyl.service.IDbVisitsService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.ArrayList;
import com.dzd.utils.ResultCode;
import com.dzd.utils.ResultData;
/**
 * @author diaozhende
 * @since 2019-07-10
 */
@RestController
@RequestMapping("/DbVisitsApi")
public class DbVisitsController{

 @Autowired
 private IDbVisitsService service = new DbVisitsServiceImpl();

/**
 * @author diaozhende
 * @since 2019-07-10
 * @Description: //TODO 查询数据列表
 */
@RequestMapping(value="/list",method= RequestMethod.GET)
 public ResultData<List<DbVisits>> list(){
    ResultData<List<DbVisits>> resultData = new ResultData<List<DbVisits>>();
    List<DbVisits> List = new ArrayList<DbVisits>();
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
     * @author diaozhende
     * @since 2019-07-10
     * @Description: //TODO 增加
     */
    @RequestMapping(value="/add",method= RequestMethod.POST)
     public ResultData<String> add(DbVisits pojo){
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
     * @author diaozhende
     * @since 2019-07-10
     * @Description: //TODO 根据id查询信息
     */
    @RequestMapping(value="/selectOne",method= RequestMethod.GET)
     public ResultData<DbVisits> selectOne(int id){
        ResultData<DbVisits> resultData = new ResultData<DbVisits>();
        DbVisits pojo = new DbVisits();
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
     * @author diaozhende
     * @since 2019-07-10
     * @Description: //TODO 修改
     */
    @RequestMapping(value="/update",method= RequestMethod.POST)
     public ResultData<String> update(DbVisits pojo){
        ResultData<String> resultData = new ResultData<String>();
        try {
            QueryWrapper<DbVisits> queryWrapper = new QueryWrapper<DbVisits>();
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
     * @author diaozhende
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
