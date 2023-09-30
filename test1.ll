; === prologue ====
declare dso_local i32 @printf(i8*, ...)

@.str0 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str3 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str4 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str5 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str6 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str7 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@.str8 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str9 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str10 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str11 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str12 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str13 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str14 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str15 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@.str16 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str17 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str18 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str19 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str20 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str21 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str22 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str23 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@.str24 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str25 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str26 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str27 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str28 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str29 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str30 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str31 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@.str32 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str33 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@.str34 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str35 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@.str36 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str37 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@.str38 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str39 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
define dso_local i32 @main()
{
%t0 = alloca i32, align 4
%t1 = alloca i32, align 4
%t2 = alloca i32, align 4
%t3 = alloca float, align 4
%t4 = alloca float, align 4
%t5 = alloca float, align 4
store i32 0, i32* %t2
store i32 10, i32* %t1
store float 0x4002b851e0000000, float* %t5
store float 0x400ab851e0000000, float* %t4
%t6 = load i32, i32* %t2
%t7 = load i32, i32* %t1
%t8 = add nsw i32 %t6, %t7
store i32 %t8, i32* %t0
%t9 = load i32, i32* %t0
%t10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str0, i64 0, i64 0), i32 %t9)
%t11 = load i32, i32* %t2
%t12 = add nsw i32 %t11, 100
store i32 %t12, i32* %t0
%t13 = load i32, i32* %t0
%t14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str1, i64 0, i64 0), i32 %t13)
%t15 = load i32, i32* %t2
%t16 = add nsw i32 100, %t15
store i32 %t16, i32* %t0
%t17 = load i32, i32* %t0
%t18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str2, i64 0, i64 0), i32 %t17)
%t19 = add nsw i32 3, 5
store i32 %t19, i32* %t0
%t20 = load i32, i32* %t0
%t21 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str3, i64 0, i64 0), i32 %t20)
%t22 = load float, float* %t5
%t23 = load float, float* %t4
%t24 = fadd float %t22, %t23
store float %t24, float* %t3
%t25 = load float, float* %t3
%t26 = fpext float %t25 to double
%t27 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str4, i64 0, i64 0), double %t26)
%t28 = load float, float* %t5
%t29 = fadd float %t28, 0x3ff3333340000000
store float %t29, float* %t3
%t30 = load float, float* %t3
%t31 = fpext float %t30 to double
%t32 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str5, i64 0, i64 0), double %t31)
%t33 = load float, float* %t5
%t34 = fadd float 0x3ff3333340000000, %t33
store float %t34, float* %t3
%t35 = load float, float* %t3
%t36 = fpext float %t35 to double
%t37 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str6, i64 0, i64 0), double %t36)
%t38 = fadd float 0x4002b851e0000000, 0x400ab851e0000000
store float %t38, float* %t3
%t39 = load float, float* %t3
%t40 = fpext float %t39 to double
%t41 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str7, i64 0, i64 0), double %t40)
%t42 = load i32, i32* %t2
%t43 = load i32, i32* %t1
%t44 = sub nsw i32 %t42, %t43
store i32 %t44, i32* %t0
%t45 = load i32, i32* %t0
%t46 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str8, i64 0, i64 0), i32 %t45)
%t47 = load i32, i32* %t2
%t48 = sub nsw i32 %t47, 5
store i32 %t48, i32* %t0
%t49 = load i32, i32* %t0
%t50 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str9, i64 0, i64 0), i32 %t49)
%t51 = load i32, i32* %t2
%t52 = sub nsw i32 5, %t51
store i32 %t52, i32* %t0
%t53 = load i32, i32* %t0
%t54 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str10, i64 0, i64 0), i32 %t53)
%t55 = sub nsw i32 3, 5
store i32 %t55, i32* %t0
%t56 = load i32, i32* %t0
%t57 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str11, i64 0, i64 0), i32 %t56)
%t58 = load float, float* %t5
%t59 = load float, float* %t4
%t60 = fsub float %t58, %t59
store float %t60, float* %t3
%t61 = load float, float* %t3
%t62 = fpext float %t61 to double
%t63 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str12, i64 0, i64 0), double %t62)
%t64 = load float, float* %t5
%t65 = fsub float %t64, 0x3ff3333340000000
store float %t65, float* %t3
%t66 = load float, float* %t3
%t67 = fpext float %t66 to double
%t68 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str13, i64 0, i64 0), double %t67)
%t69 = load float, float* %t5
%t70 = fsub float 0x3ff3333340000000, %t69
store float %t70, float* %t3
%t71 = load float, float* %t3
%t72 = fpext float %t71 to double
%t73 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str14, i64 0, i64 0), double %t72)
%t74 = fsub float 0x4002b851e0000000, 0x3ff4ccccc0000000
store float %t74, float* %t3
%t75 = load float, float* %t3
%t76 = fpext float %t75 to double
%t77 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str15, i64 0, i64 0), double %t76)
%t78 = load i32, i32* %t2
%t79 = load i32, i32* %t1
%t80 = mul nsw i32 %t78, %t79
store i32 %t80, i32* %t0
%t81 = load i32, i32* %t0
%t82 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str16, i64 0, i64 0), i32 %t81)
%t83 = load i32, i32* %t2
%t84 = mul nsw i32 %t83, 5
store i32 %t84, i32* %t0
%t85 = load i32, i32* %t0
%t86 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str17, i64 0, i64 0), i32 %t85)
%t87 = load i32, i32* %t2
%t88 = mul nsw i32 5, %t87
store i32 %t88, i32* %t0
%t89 = load i32, i32* %t0
%t90 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str18, i64 0, i64 0), i32 %t89)
%t91 = mul nsw i32 3, 5
store i32 %t91, i32* %t0
%t92 = load i32, i32* %t0
%t93 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str19, i64 0, i64 0), i32 %t92)
%t94 = load float, float* %t5
%t95 = load float, float* %t4
%t96 = fmul float %t94, %t95
store float %t96, float* %t3
%t97 = load float, float* %t3
%t98 = fpext float %t97 to double
%t99 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str20, i64 0, i64 0), double %t98)
%t100 = load float, float* %t5
%t101 = fmul float %t100, 0x3ff3333340000000
store float %t101, float* %t3
%t102 = load float, float* %t3
%t103 = fpext float %t102 to double
%t104 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str21, i64 0, i64 0), double %t103)
%t105 = load float, float* %t5
%t106 = fmul float 0x3ff3333340000000, %t105
store float %t106, float* %t3
%t107 = load float, float* %t3
%t108 = fpext float %t107 to double
%t109 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str22, i64 0, i64 0), double %t108)
%t110 = fmul float 0x4002b851e0000000, 0x3ff4ccccc0000000
store float %t110, float* %t3
%t111 = load float, float* %t3
%t112 = fpext float %t111 to double
%t113 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str23, i64 0, i64 0), double %t112)
%t114 = load i32, i32* %t2
%t115 = load i32, i32* %t1
%t116 = sdiv i32 %t114, %t115
store i32 %t116, i32* %t0
%t117 = load i32, i32* %t0
%t118 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str24, i64 0, i64 0), i32 %t117)
%t119 = load i32, i32* %t2
%t120 = sdiv i32 %t119, 5
store i32 %t120, i32* %t0
%t121 = load i32, i32* %t0
%t122 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str25, i64 0, i64 0), i32 %t121)
%t123 = load i32, i32* %t1
%t124 = sdiv i32 5, %t123
store i32 %t124, i32* %t0
%t125 = load i32, i32* %t0
%t126 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str26, i64 0, i64 0), i32 %t125)
%t127 = sdiv i32 3, 5
store i32 %t127, i32* %t0
%t128 = load i32, i32* %t0
%t129 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str27, i64 0, i64 0), i32 %t128)
%t130 = load float, float* %t5
%t131 = load float, float* %t4
%t132 = fdiv float %t130, %t131
store float %t132, float* %t3
%t133 = load float, float* %t3
%t134 = fpext float %t133 to double
%t135 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str28, i64 0, i64 0), double %t134)
%t136 = load float, float* %t5
%t137 = fdiv float %t136, 0x3ff3333340000000
store float %t137, float* %t3
%t138 = load float, float* %t3
%t139 = fpext float %t138 to double
%t140 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str29, i64 0, i64 0), double %t139)
%t141 = load float, float* %t5
%t142 = fdiv float 0x3ff3333340000000, %t141
store float %t142, float* %t3
%t143 = load float, float* %t3
%t144 = fpext float %t143 to double
%t145 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str30, i64 0, i64 0), double %t144)
%t146 = fdiv float 0x4002b851e0000000, 0x3ff4ccccc0000000
store float %t146, float* %t3
%t147 = load float, float* %t3
%t148 = fpext float %t147 to double
%t149 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str31, i64 0, i64 0), double %t148)
%t150 = load i32, i32* %t1
%t151 = sub nsw i32 100, 1
%t152 = mul nsw i32 2, %t151
%t153 = add nsw i32 %t150, %t152
store i32 %t153, i32* %t2
%t154 = load float, float* %t5
%t155 = fmul float %t154, 0x4002b851e0000000
%t156 = fadd float 0x3ff3333340000000, 0x4000000000000000
%t157 = fadd float %t155, %t156
store float %t157, float* %t3
%t158 = load i32, i32* %t2
%t159 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str32, i64 0, i64 0), i32 %t158)
%t160 = load float, float* %t3
%t161 = fpext float %t160 to double
%t162 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str33, i64 0, i64 0), double %t161)
%t163 = load i32, i32* %t1
%t164 = load i32, i32* %t0
%t165 = sub nsw i32 100, 2
%t166 = mul nsw i32 %t164, %t165
%t167 = add nsw i32 %t163, %t166
%t168 = mul nsw i32 2, 3
%t169 = sdiv i32 %t168, 2
%t170 = add nsw i32 %t167, %t169
store i32 %t170, i32* %t2
%t171 = load i32, i32* %t2
%t172 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str34, i64 0, i64 0), i32 %t171)
%t173 = load float, float* %t5
%t174 = load float, float* %t4
%t175 = fsub float 0x3ff4ccccc0000000, 0x4012000000000000
%t176 = fmul float %t174, %t175
%t177 = fadd float %t173, %t176
%t178 = fmul float 0x4014ccccc0000000, 0x3ff3333340000000
%t179 = fdiv float %t178, 0x4011333340000000
%t180 = fadd float %t177, %t179
store float %t180, float* %t3
%t181 = load float, float* %t3
%t182 = fpext float %t181 to double
%t183 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str35, i64 0, i64 0), double %t182)
%t184 = load i32, i32* %t2
%t185 = sub nsw i32 0, %t184
store i32 %t185, i32* %t2
%t186 = load i32, i32* %t2
%t187 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str36, i64 0, i64 0), i32 %t186)
%t188 = load float, float* %t3
%t189 = fsub float 0x0000000000000000, %t188
store float %t189, float* %t3
%t190 = load float, float* %t3
%t191 = fpext float %t190 to double
%t192 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str37, i64 0, i64 0), double %t191)
%t193 = load i32, i32* %t2
%t194 = sub nsw i32 0, %t193
%t195 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str38, i64 0, i64 0), i32 %t194)
%t196 = load float, float* %t3
%t197 = fsub float 0x0000000000000000, %t196
%t198 = fpext float %t197 to double
%t199 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str39, i64 0, i64 0), double %t198)

; === epilogue ===
ret i32 0
}
