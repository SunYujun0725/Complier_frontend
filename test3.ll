; === prologue ====
declare dso_local i32 @printf(i8*, ...)

@str0 = private unnamed_addr constant [13 x i8] c"Hello world\0A\00"
@str1 = private unnamed_addr constant [12 x i8] c"Hello world\00"
@.str2 = private unnamed_addr constant [7 x i8] c"a: %d\0A\00"
@str3 = private unnamed_addr constant [7 x i8] c"b: %f\0A\00"
@.str4 = private unnamed_addr constant [6 x i8] c"a: %d\00"
@str5 = private unnamed_addr constant [6 x i8] c"b: %f\00"
define dso_local i32 @main()
{
%t0 = alloca float, align 4
%t1 = alloca i32, align 4
store i32 10, i32* %t1
store float 0x4002666660000000, float* %t0
%t2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([13 x i8], [13 x i8]* @str0, i64 0, i64 0))
%t3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([12 x i8], [12 x i8]* @str1, i64 0, i64 0))
%t4 = load i32, i32* %t1
%t5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @.str2, i64 0, i64 0), i32 %t4)
%t6 = load float, float* %t0
%t7 = fpext float %t6 to double
%t8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @str3, i64 0, i64 0), double %t7)
%t9 = load i32, i32* %t1
%t10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([6 x i8], [6 x i8]* @.str4, i64 0, i64 0), i32 %t9)
%t11 = load float, float* %t0
%t12 = fpext float %t11 to double
%t13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([6 x i8], [6 x i8]* @str5, i64 0, i64 0), double %t12)

; === epilogue ===
ret i32 0
}
