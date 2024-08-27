<template>
    <div class="app-container">
        <!-- 输入表单 -->
        <el-form label-width="120px">
            <el-form-item label="借款额度">
                <el-input-number v-model="integralGrade.borrowAmount" :min="0" />
            </el-form-item>
            <el-form-item label="积分区间开始">
                <el-input-number v-model="integralGrade.integralStart" :min="0" />
            </el-form-item>
            <el-form-item label="积分区间结束">
                <el-input-number v-model="integralGrade.integralEnd" :min="0" />
            </el-form-item>
            <el-form-item>
                <el-button :disabled="saveBtnDisabled" type="primary" @click="saveOrUpdate()">
                    保存
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import integralGradeApi from '@/api/integral-grade'
export default {
    data() {
        return {
            integralGrade: {},
            saveBtnDisabled: false,
            id: '',
        }
    },
    created() {
        //1. 得到积分id
        this.id = this.$route.params.id
        // 2. 根据积分id查询出积分对象
        this.findIntegralGrade(this.id)
    },
    methods: {
        // 1. 根据id查询积分等级
        findIntegralGrade(id) {
            if (id) {
                integralGradeApi.findById(id).then(resp => {
                    this.integralGrade = resp.data.integralGrade
                })
            }

        },
        // 2. 保存积分
        saveOrUpdate() {
            this.saveBtnDisabled = true
            // 2.1 确定url地址
            let url = "/admin/core/integralGrade/add"
            let method = "post" // 添加
            if (this.id) {
                url = "/admin/core/integralGrade/update"
                method = "put"    // 修改
            }
            // 2.2 提交到后台
            integralGradeApi.save(this.integralGrade, method, url).then(resp => {
                this.$message.success(resp.message)
                this.$router.push("/core/integral-grade/list")

            })
        }
    },
}
</script>

<style scoped></style>