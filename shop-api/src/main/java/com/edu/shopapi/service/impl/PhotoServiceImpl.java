package com.edu.shopapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.shopapi.dao.PhotoDao;
import com.edu.shopapi.entity.Photo;
import com.edu.shopapi.service.PhotoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品轮播图标(Photo)表服务实现类
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Service("photoService")
public class PhotoServiceImpl extends ServiceImpl<PhotoDao, Photo> implements PhotoService {
    @Resource
    private PhotoDao photoDao;
    @Override
    public List<Photo> queryAllPhoto(Integer productId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("product_id",productId);
        return photoDao.selectList(qw);
    }
}

