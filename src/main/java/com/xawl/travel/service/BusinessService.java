package com.xawl.travel.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.Server;
import com.xawl.travel.dao.BusinessMapper;
import com.xawl.travel.pojo.Business;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.Result;
import com.xawl.travel.utils.UploadImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lzp on 2017/11/15.
 */
@Service
public class BusinessService {
    @Autowired
    BusinessMapper businessMapper;
    /**
     * 登录
     * 根据selectByPramaryKey查询出密码
     *商家是否存在  是
     *                   对比密码  对着  200
     *                             不对  405-密码错误
     *               否  404-找不到对象
     */
    public Result login(String bid,String pass){
        Result result=new Result();
        Business business= businessMapper.selectByPrimaryKey(bid);
        if(business==null){
            result.setStatus(404);
            result.setMsg("找不到该商家");
            return result;
        }
        if(!pass.equals(business.getPass())){
            result.setStatus(404);
            result.setMsg("密码错误");
            return result;
        }
       return result.success(200);

    }


    /**
     * 查询全部
     * @return
     */
    /*public List<Business> findAll(){

        return businessMapper.findAll();
    }*/
    public Result findAll(Integer page){
        //设置显示10条记录  pageNum是当前页面(页数),pageSize是每页显示的数据行数
        PageHelper.startPage(page,7);
        List<Business> list= businessMapper.findByBname(null);
        PageInfo pageInfo=new PageInfo(list);
        Result result=new Result();
        if(page<=pageInfo.getLastPage()){
            result.setStatus(200);
            result.setMsg("查询成功");
            result.setData(pageInfo);
        }else{
            result.setStatus(405);
            result.setMsg("没有记录数");
        }
        return result;
    }

    /**
     * 通过名称模糊查询
     * @param bname
     * @return
     */
   public List<Business> findByBname(Business bname) {
       /* try{
            businessMapper.findByBname(bname);
            return Result.success(bname);
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail(405,"没有相关的查询记录");
       }*/
       return businessMapper.findByBname(bname);
    }

    public Business selectByPrimaryKey(String bid){
        return businessMapper.selectByPrimaryKey(bid);
    }

    /*public int selectByBid(String bid){
        return businessMapper.selectByBid(bid);
    }*/

    /**
     * 添加商家
     * 分析：
     * 1.bname和address不能为空
     * 2.bid和is_use默认设置
     * 3.图片的上传
     * @param record
     * @param request
     * @param file
     * @return
     */
    public Result insert(Business record, HttpServletRequest request,MultipartFile file){
        Result result=new Result();
        //1.bname和address不能为空
        if(record.getBname()==null||record.getBname().equals("")){
            result.setStatus(404);
            result.setMsg("商家名称不能为空");
            return result;
        }
        if(record.getAddress()==null||record.getAddress().equals("")){
            result.setStatus(404);
            result.setMsg("地址不能为空");
            return result;
        }
        //2.bid和is_use默认设置
        record.setBid(CreateId.gitId());
        record.setIsUse(false);
        //3.图片上传
        UploadImages uploadImage = new UploadImages();

        String path1 = request.getSession().getServletContext().getRealPath("/");  //上传的路径
         String path2 = "Business/Img";  //保存的文件夹
        //String path2 = "/"+"img"+"/"+"business"+"/"+"Img";
        String imgPath = uploadImage.upLoadImage(request, file, path1, path2);
        if (!imgPath.contains(".")) {
            return Result.fail("未选择上传文件");
        }
        record.setImage(imgPath);
        try {
            int rows=businessMapper.insertSelective(record);
            if(rows==0){
                return Result.fail(405,"添加失败");
            }else{
                return Result.success(record);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(405,"添加失败");
        }
    }

    /**
     *  修改
     *  1.看是否有该ID  有  得到指定ID的信息
     *                  无  提示信息
      * @param record
     * @param request
     * @param file
     * @return
     */
    public Result updateByPrimaryKey(Business record, HttpServletRequest request,MultipartFile file){
        Result result=new Result();
        //1.查看是否有该ID
        if(businessMapper.selectByPrimaryKey(record.getBid())!=null){
            //２.bname和address不能为空
            if(record.getBname()==null||record.getBname().equals("")){
                result.setStatus(404);
                result.setMsg("商家名称不能为空");
                return result;
            }
            if(record.getAddress()==null||record.getAddress().equals("")){
                result.setStatus(404);
                result.setMsg("地址不能为空");
                return result;
            }
            record.setIsUse(false);
            //3.图片上传
            UploadImages uploadImage = new UploadImages();
            String path1 = request.getSession().getServletContext().getRealPath("/");  //上传的路径
            String path2 = "Business/Img";  //保存的文件夹
            String imgPath = uploadImage.upLoadImage(request, file, path1, path2);
            if (!imgPath.contains(".")) {
                return Result.fail("未选择上传文件");
            }
            record.setImage(imgPath);
           /* System.out.println(record+"+++++++++++++++++++++++++++++++++");*/
            try {
                int rows=businessMapper.updateByPrimaryKey(record);
                if(rows==0){
                    return Result.fail(405,"修改失败！！");
                }else{
                    return Result.success(record);
                }
            }catch (Exception e){
                e.printStackTrace();
                return Result.fail(405,"修改失败");
            }
        }
        return Result.fail(405,"查询不到此商家");
    }

/*    public int updateByPrimaryKeySelective(Business record){
        return businessMapper.updateByPrimaryKeySelective(record);
    }*/

    /**
     * 停用
     */
    public Result updateBusinessDisable(String bid) {
        try {
            if ( businessMapper.selectByPrimaryKey(bid).getBid()!=null) {
                businessMapper.updateBusinessDisable(bid);
                return Result.success(200);
            }
            return Result.fail(405, "查询不到此商家");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(405, "停用失败");
        }
    }
        /**
         * 设置可以使用
         */
    public Result updateBusinessAble(String bid){
        try{
            if(businessMapper.selectByPrimaryKey(bid).getBid()!=null){
                businessMapper.updateBusinessAble(bid);
                return Result.success(200);
            }
            return Result.fail(405,"查询不到此商家");
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail(405,"复用失败");
        }
    }
}
