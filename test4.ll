; === prologue ====
declare dso_local i32 @printf(i8*, ...)

@.str0 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
define dso_local i32 @main()
{
%t0 = alloca i32, align 4
%t1 = alloca i32, align 4
%t2 = alloca i32, align 4
store i32 10, i32* %t1
store i32 0, i32* %t0
store i32 0, i32* %t2
br label %L1
L1:
%t3 = load i32, i32* %t2
%t4 = icmp sle i32 %t3, 10
br i1 %t4, label %L2, label %L3
L2:
%t5 = load i32, i32* %t2
%t6 = add nsw i32 %t5, 1
%t7 = load i32, i32* %t1
%t8 = add nsw i32 %t7, 1
store i32 %t8, i32* %t1
%t9 = load i32, i32* %t1
%t10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str0, i64 0, i64 0), i32 %t9)
store i32 %t6, i32* %t2
br label %L1
L3:
br label %L4
L4:
%t11 = load i32, i32* %t0
%t12 = icmp sle i32 %t11, 10
br i1 %t12, label %L5, label %L6
L5:
%t13 = load i32, i32* %t0
%t14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str1, i64 0, i64 0), i32 %t13)
%t15 = load i32, i32* %t0
%t16 = add nsw i32 %t15, 1
store i32 %t16, i32* %t0
br label %L4
L6:
%t17 = load i32, i32* %t0
%t18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str2, i64 0, i64 0), i32 %t17)

; === epilogue ===
ret i32 0
}
