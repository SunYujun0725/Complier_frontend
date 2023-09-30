; === prologue ====
declare dso_local i32 @printf(i8*, ...)

@.str0 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@str2 = private unnamed_addr constant [13 x i8] c"c >= 0.0 %f\0A\00"
@str3 = private unnamed_addr constant [13 x i8] c"c < 10.0 %f\0A\00"
@str4 = private unnamed_addr constant [13 x i8] c"d <= 0.0 %f\0A\00"
@str5 = private unnamed_addr constant [11 x i8] c"d > 0.0%f\0A\00"
@str6 = private unnamed_addr constant [7 x i8] c"a = b\0A\00"
@str7 = private unnamed_addr constant [6 x i8] c"a!=b\0A\00"
@str8 = private unnamed_addr constant [4 x i8] c"%f\0A\00"
@str9 = private unnamed_addr constant [8 x i8] c"c != d\0A\00"
@str10 = private unnamed_addr constant [8 x i8] c"c == d\0A\00"
define dso_local i32 @main()
{
%t0 = alloca float, align 4
%t1 = alloca float, align 4
%t2 = alloca i32, align 4
%t3 = alloca i32, align 4
store i32 0, i32* %t3
store i32 10, i32* %t2
%t4 = load i32, i32* %t2
%t5 = sub nsw i32 100, 1
%t6 = mul nsw i32 2, %t5
%t7 = add nsw i32 %t4, %t6
store i32 %t7, i32* %t3
store float 0x4002b851e0000000, float* %t1
%t8 = fmul float 0x4002666660000000, 0x4015333340000000
store float %t8, float* %t0
%t9 = load float, float* %t0
%t10 = fsub float 0x0000000000000000, %t9
store float %t10, float* %t0
%t11 = load i32, i32* %t3
%t12 = load i32, i32* %t2
%t13 = icmp sgt i32 %t11, %t12
br i1 %t13, label %L1, label %L2
L1:
%t14 = load i32, i32* %t3
%t15 = add nsw i32 %t14, 1
store i32 %t15, i32* %t3
%t16 = load i32, i32* %t3
%t17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str0, i64 0, i64 0), i32 %t16)
br label %L3
L2:
%t18 = load i32, i32* %t2
%t19 = add nsw i32 %t18, 1
store i32 %t19, i32* %t2
%t20 = load i32, i32* %t2
%t21 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str1, i64 0, i64 0), i32 %t20)
br label %L3
L3:
%t22 = load float, float* %t1
%t23 = fcmp oge float %t22, 0.0
br i1 %t23, label %L4, label %L5
L4:
%t24 = load float, float* %t1
%t25 = fpext float %t24 to double
%t26 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([13 x i8], [13 x i8]* @str2, i64 0, i64 0), double %t25)
br label %L5
L5:
%t27 = load float, float* %t1
%t28 = fadd float %t27, 0x4004000000000000
store float %t28, float* %t1
%t29 = load float, float* %t1
%t30 = fcmp olt float %t29, 10.0
br i1 %t30, label %L6, label %L7
L6:
%t31 = load float, float* %t1
%t32 = fpext float %t31 to double
%t33 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([13 x i8], [13 x i8]* @str3, i64 0, i64 0), double %t32)
br label %L7
L7:
%t34 = load float, float* %t0
%t35 = fcmp ole float %t34, 0.0
br i1 %t35, label %L8, label %L9
L8:
%t36 = load float, float* %t0
%t37 = fpext float %t36 to double
%t38 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([13 x i8], [13 x i8]* @str4, i64 0, i64 0), double %t37)
br label %L10
L9:
%t39 = load float, float* %t0
%t40 = fpext float %t39 to double
%t41 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([11 x i8], [11 x i8]* @str5, i64 0, i64 0), double %t40)
br label %L10
L10:
store i32 0, i32* %t3
store i32 0, i32* %t2
%t42 = load i32, i32* %t3
%t43 = load i32, i32* %t2
%t44 = icmp eq i32 %t42, %t43
br i1 %t44, label %L11, label %L12
L11:
%t45 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @str6, i64 0, i64 0))
br label %L12
L12:
%t46 = sub nsw i32 0, 5
store i32 %t46, i32* %t2
%t47 = load i32, i32* %t3
%t48 = load i32, i32* %t2
%t49 = icmp ne i32 %t47, %t48
br i1 %t49, label %L13, label %L14
L13:
%t50 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([6 x i8], [6 x i8]* @str7, i64 0, i64 0))
br label %L14
L14:
%t51 = fsub float 0x0000000000000000, 0x4002b851e0000000
store float %t51, float* %t1
%t52 = load float, float* %t1
%t53 = fpext float %t52 to double
%t54 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @str8, i64 0, i64 0), double %t53)
store float 0x4004000000000000, float* %t0
%t55 = load float, float* %t1
%t56 = load float, float* %t0
%t57 = fcmp une float %t55, %t56
br i1 %t57, label %L15, label %L16
L15:
%t58 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @str9, i64 0, i64 0))
br label %L16
L16:
%t59 = load float, float* %t0
store float %t59, float* %t1
%t60 = load float, float* %t1
%t61 = load float, float* %t0
%t62 = fcmp oeq float %t60, %t61
br i1 %t62, label %L17, label %L18
L17:
%t63 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @str10, i64 0, i64 0))
br label %L18
L18:

; === epilogue ===
ret i32 0
}
