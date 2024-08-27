<template>
    <div class="app-container">
        <!-- 表格 -->
        <el-table :data="list" border stripe>
            <el-table-column type="index" width="50" align="center" />
            <el-table-column prop="borrowAmount" label="借款额度" align="center" />
            <el-table-column prop="integralStart" label="积分区间开始" align="center" />
            <el-table-column prop="integralEnd" label="积分区间结束" align="center" />
            <el-table-column label="操作" width="200" align="center">
                <template slot-scope="scope">
                    <router-link :to="'/core/integral-grade/edit/' + scope.row.id" style="margin-right:5px;">
                        <el-button type="primary" size="mini" icon="el-icon-edit">
                            修改
                        </el-button>
                    </router-link>

                    <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeById(scope.row.id)">
                        删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>


<script>
import integralGradeApi from '@/api/integral-grade'
export default {
    data() {
        return {
            list: [],
        }
    },
    created() {
        this.findAllIntegralGrades()
    },
    methods: {
        // 1. 查询积分等级
        findAllIntegralGrades() {
            integralGradeApi.list().then(resp => {
                console.log("list:", resp)
                this.list = resp.data.list
            })
        },
        // 2. 删除积分等级
        removeById(id) {
            let _this = this
            this.$confirm('是否真的删除此积分等级?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {   // 点击确认按钮执行的操作
                integralGradeApi.removeById(id).then(resp => {
                    if (resp.code === 0) {
                        this.$message({
                            type: 'success',
                            message: resp.message,
                            onClose() {    // 当关闭提示框时重新加载页面
                                _this.findAllIntegralGrades()
                            }
                        })
                    }
                })

            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                })
            })


        }
    }
}
</script>

<style scoped></style>