package cn.itsource.pethome.org.controller;

import cn.itsource.pethome.org.util.AjaxResult;
import cn.itsource.pethome.org.util.FastDfsApiOprUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @version v1.8
 * @ProjectName: PetHome
 * @ClassName: FastDfsController
 * @Description: 图片上传
 * @Author: xiangke
 * @Date: 2020/7/11 10:59
 */
@RestController
@RequestMapping("/dfs")
public class FastDfsController {

    @PostMapping
    public AjaxResult upload(@RequestPart(required = true,value = "file") MultipartFile file) {
        try {
            //获取原始文件名(为了获取文件后缀)
            String originalFilename = file.getOriginalFilename();
            //截取文件后缀
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
            //使用工具类中的上传文件方法
            String path  = FastDfsApiOprUtil.upload(file.getBytes(),extName);
            return AjaxResult.me().setResultObj(path);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("上传失败");
        }
    }

    @DeleteMapping
    public AjaxResult delete(@RequestParam(value = "path") String path) {
        ///group1/M00/00/32/wKgABF8JWQyAa1spAAEwuZ9CYHo719.jpg
        String[] split = path.split("/");
        String fileName=split[2]+"/"+split[3]+"/"+split[4]+"/"+split[5];
        FastDfsApiOprUtil.delete(split[1],fileName);
        return AjaxResult.me();
    }
}
