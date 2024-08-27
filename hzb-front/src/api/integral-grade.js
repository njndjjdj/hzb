import request from '@/utils/request'
export default {
    // 1. 查询积分等级
    list() {
        return request({
            url: '/admin/core/integralGrade/list',
            method: 'get'
        })
    },
    // 2. 删除积分等级
    removeById(id) {
        return request({
            url: '/admin/core/integralGrade/removeById/' + id,
            method: 'delete'
        })
    },
    //3. 根据id查询积分等级
    findById(id) {
        return request({
            url: '/admin/core/integralGrade/findById/' + id,
            method: 'get'
        })
    },
    //4. 保存积分等级
    save(data, method, url) {
        return request({
            url,
            method,
            data
        })
    }
}