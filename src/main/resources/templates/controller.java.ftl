package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import ${package.Entity}.${entity};
import ${package.ServiceImpl}.${table.serviceImplName};
import ${package.Service}.${table.serviceName};
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.ArrayList;
import com.dzd.utils.ResultCode;
import com.dzd.utils.ResultData;
/**
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/${table.entityName}Api")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
public class ${table.controllerName}{

 @Autowired
 private ${table.serviceName} service = new ${table.serviceImplName}();

/**
 * @author ${author}
 * @since ${date}
 * @Description: //TODO 查询数据列表
 */
@RequestMapping(value="/list",method= RequestMethod.GET)
 public ResultData<List<${table.entityName}>> list(){
    ResultData<List<${table.entityName}>> resultData = new ResultData<List<${table.entityName}>>();
    List<${table.entityName}> List = new ArrayList<${table.entityName}>();
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
     * @author ${author}
     * @since ${date}
     * @Description: //TODO 增加
     */
    @RequestMapping(value="/add",method= RequestMethod.POST)
     public ResultData<String> add(${table.entityName} pojo){
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
     * @author ${author}
     * @since ${date}
     * @Description: //TODO 根据id查询信息
     */
    @RequestMapping(value="/selectOne",method= RequestMethod.GET)
     public ResultData<${table.entityName}> selectOne(int id){
        ResultData<${table.entityName}> resultData = new ResultData<${table.entityName}>();
        ${table.entityName} pojo = new ${table.entityName}();
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
     * @author ${author}
     * @since ${date}
     * @Description: //TODO 修改
     */
    @RequestMapping(value="/update",method= RequestMethod.POST)
     public ResultData<String> update(${table.entityName} pojo){
        ResultData<String> resultData = new ResultData<String>();
        try {
            QueryWrapper<${table.entityName}> queryWrapper = new QueryWrapper<${table.entityName}>();
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
     * @author ${author}
     * @since ${date}
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
</#if>
