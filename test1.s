	.text
	.file	"test1.ll"
	.section	.rodata.cst4,"aM",@progbits,4
	.p2align	2               # -- Begin function main
.LCPI0_0:
	.long	1067030938              # float 1.20000005
.LCPI0_5:
	.long	1075167887              # float 2.33999991
.LCPI0_6:
	.long	1078774989              # float 3.20000005
.LCPI0_7:
	.long	3226258637              # float -3.20000005
.LCPI0_8:
	.long	1069137844              # float 1.45116282
	.section	.rodata.cst8,"aM",@progbits,8
	.p2align	3
.LCPI0_1:
	.quad	4618081129704980480     # double 5.679999828338623
.LCPI0_2:
	.quad	4607362562613313536     # double 1.0399999618530273
.LCPI0_3:
	.quad	4614032393420931072     # double 3.0419998168945313
.LCPI0_4:
	.quad	4610785298287165440     # double 1.7999999523162842
	.text
	.globl	main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movl	$0, 8(%rsp)
	movl	$10, 16(%rsp)
	movl	$1075167887, 12(%rsp)   # imm = 0x4015C28F
	movl	$1079362191, 20(%rsp)   # imm = 0x4055C28F
	movl	$10, 4(%rsp)
	movl	$.L.str0, %edi
	movl	$10, %esi
	xorl	%eax, %eax
	callq	printf
	movl	8(%rsp), %esi
	addl	$100, %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str1, %edi
	xorl	%eax, %eax
	callq	printf
	movl	8(%rsp), %esi
	addl	$100, %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str2, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$8, 4(%rsp)
	movl	$.L.str3, %edi
	movl	$8, %esi
	xorl	%eax, %eax
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	addss	20(%rsp), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr4, %edi
	movb	$1, %al
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	addss	.LCPI0_0(%rip), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr5, %edi
	movb	$1, %al
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	addss	.LCPI0_0(%rip), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr6, %edi
	movb	$1, %al
	callq	printf
	movl	$1085653647, (%rsp)     # imm = 0x40B5C28F
	movsd	.LCPI0_1(%rip), %xmm0   # xmm0 = mem[0],zero
	movl	$.Lstr7, %edi
	movb	$1, %al
	callq	printf
	movl	8(%rsp), %esi
	subl	16(%rsp), %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str8, %edi
	xorl	%eax, %eax
	callq	printf
	movl	8(%rsp), %esi
	addl	$-5, %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str9, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$5, %esi
	subl	8(%rsp), %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str10, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$-2, 4(%rsp)
	movl	$.L.str11, %edi
	movl	$-2, %esi
	xorl	%eax, %eax
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	subss	20(%rsp), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr12, %edi
	movb	$1, %al
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	subss	.LCPI0_0(%rip), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr13, %edi
	movb	$1, %al
	callq	printf
	movss	.LCPI0_0(%rip), %xmm0   # xmm0 = mem[0],zero,zero,zero
	subss	12(%rsp), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr14, %edi
	movb	$1, %al
	callq	printf
	movl	$1065688760, (%rsp)     # imm = 0x3F851EB8
	movsd	.LCPI0_2(%rip), %xmm0   # xmm0 = mem[0],zero
	movl	$.Lstr15, %edi
	movb	$1, %al
	callq	printf
	movl	8(%rsp), %esi
	imull	16(%rsp), %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str16, %edi
	xorl	%eax, %eax
	callq	printf
	movl	8(%rsp), %eax
	leal	(%rax,%rax,4), %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str17, %edi
	xorl	%eax, %eax
	callq	printf
	movl	8(%rsp), %eax
	leal	(%rax,%rax,4), %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str18, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$15, 4(%rsp)
	movl	$.L.str19, %edi
	movl	$15, %esi
	xorl	%eax, %eax
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	mulss	20(%rsp), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr20, %edi
	movb	$1, %al
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	mulss	.LCPI0_0(%rip), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr21, %edi
	movb	$1, %al
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	mulss	.LCPI0_0(%rip), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr22, %edi
	movb	$1, %al
	callq	printf
	movl	$1078112288, (%rsp)     # imm = 0x4042B020
	movsd	.LCPI0_3(%rip), %xmm0   # xmm0 = mem[0],zero
	movl	$.Lstr23, %edi
	movb	$1, %al
	callq	printf
	movl	8(%rsp), %eax
	cltd
	idivl	16(%rsp)
	movl	%eax, 4(%rsp)
	movl	$.L.str24, %edi
	movl	%eax, %esi
	xorl	%eax, %eax
	callq	printf
	movslq	8(%rsp), %rax
	imulq	$1717986919, %rax, %rsi # imm = 0x66666667
	movq	%rsi, %rax
	shrq	$63, %rax
	sarq	$33, %rsi
	addl	%eax, %esi
	movl	%esi, 4(%rsp)
	movl	$.L.str25, %edi
                                        # kill: def $esi killed $esi killed $rsi
	xorl	%eax, %eax
	callq	printf
	movl	$5, %eax
	xorl	%edx, %edx
	idivl	16(%rsp)
	movl	%eax, 4(%rsp)
	movl	$.L.str26, %edi
	movl	%eax, %esi
	xorl	%eax, %eax
	callq	printf
	movl	$0, 4(%rsp)
	movl	$.L.str27, %edi
	xorl	%esi, %esi
	xorl	%eax, %eax
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	divss	20(%rsp), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr28, %edi
	movb	$1, %al
	callq	printf
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	divss	.LCPI0_0(%rip), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr29, %edi
	movb	$1, %al
	callq	printf
	movss	.LCPI0_0(%rip), %xmm0   # xmm0 = mem[0],zero,zero,zero
	divss	12(%rsp), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr30, %edi
	movb	$1, %al
	callq	printf
	movl	$1072064102, (%rsp)     # imm = 0x3FE66666
	movsd	.LCPI0_4(%rip), %xmm0   # xmm0 = mem[0],zero
	movl	$.Lstr31, %edi
	movb	$1, %al
	callq	printf
	movl	$198, %esi
	addl	16(%rsp), %esi
	movl	%esi, 8(%rsp)
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	mulss	.LCPI0_5(%rip), %xmm0
	addss	.LCPI0_6(%rip), %xmm0
	movss	%xmm0, (%rsp)
	movl	$.L.str32, %edi
	xorl	%eax, %eax
	callq	printf
	movss	(%rsp), %xmm0           # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr33, %edi
	movb	$1, %al
	callq	printf
	movl	16(%rsp), %eax
	imull	$98, 4(%rsp), %ecx
	leal	3(%rax,%rcx), %esi
	movl	%esi, 8(%rsp)
	movl	$.L.str34, %edi
	xorl	%eax, %eax
	callq	printf
	movss	20(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	mulss	.LCPI0_7(%rip), %xmm0
	addss	12(%rsp), %xmm0
	addss	.LCPI0_8(%rip), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr35, %edi
	movb	$1, %al
	callq	printf
	xorl	%esi, %esi
	subl	8(%rsp), %esi
	movl	%esi, 8(%rsp)
	movl	$.L.str36, %edi
	xorl	%eax, %eax
	callq	printf
	xorps	%xmm0, %xmm0
	subss	(%rsp), %xmm0
	movss	%xmm0, (%rsp)
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr37, %edi
	movb	$1, %al
	callq	printf
	xorl	%esi, %esi
	subl	8(%rsp), %esi
	movl	$.L.str38, %edi
	xorl	%eax, %eax
	callq	printf
	xorps	%xmm0, %xmm0
	subss	(%rsp), %xmm0
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr39, %edi
	movb	$1, %al
	callq	printf
	xorl	%eax, %eax
	addq	$24, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc
                                        # -- End function
	.type	.L.str0,@object         # @.str0
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str0:
	.asciz	"%d\n"
	.size	.L.str0, 4

	.type	.L.str1,@object         # @.str1
.L.str1:
	.asciz	"%d\n"
	.size	.L.str1, 4

	.type	.L.str2,@object         # @.str2
.L.str2:
	.asciz	"%d\n"
	.size	.L.str2, 4

	.type	.L.str3,@object         # @.str3
.L.str3:
	.asciz	"%d\n"
	.size	.L.str3, 4

	.type	.Lstr4,@object          # @str4
.Lstr4:
	.asciz	"%f\n"
	.size	.Lstr4, 4

	.type	.Lstr5,@object          # @str5
.Lstr5:
	.asciz	"%f\n"
	.size	.Lstr5, 4

	.type	.Lstr6,@object          # @str6
.Lstr6:
	.asciz	"%f\n"
	.size	.Lstr6, 4

	.type	.Lstr7,@object          # @str7
.Lstr7:
	.asciz	"%f\n"
	.size	.Lstr7, 4

	.type	.L.str8,@object         # @.str8
.L.str8:
	.asciz	"%d\n"
	.size	.L.str8, 4

	.type	.L.str9,@object         # @.str9
.L.str9:
	.asciz	"%d\n"
	.size	.L.str9, 4

	.type	.L.str10,@object        # @.str10
.L.str10:
	.asciz	"%d\n"
	.size	.L.str10, 4

	.type	.L.str11,@object        # @.str11
.L.str11:
	.asciz	"%d\n"
	.size	.L.str11, 4

	.type	.Lstr12,@object         # @str12
.Lstr12:
	.asciz	"%f\n"
	.size	.Lstr12, 4

	.type	.Lstr13,@object         # @str13
.Lstr13:
	.asciz	"%f\n"
	.size	.Lstr13, 4

	.type	.Lstr14,@object         # @str14
.Lstr14:
	.asciz	"%f\n"
	.size	.Lstr14, 4

	.type	.Lstr15,@object         # @str15
.Lstr15:
	.asciz	"%f\n"
	.size	.Lstr15, 4

	.type	.L.str16,@object        # @.str16
.L.str16:
	.asciz	"%d\n"
	.size	.L.str16, 4

	.type	.L.str17,@object        # @.str17
.L.str17:
	.asciz	"%d\n"
	.size	.L.str17, 4

	.type	.L.str18,@object        # @.str18
.L.str18:
	.asciz	"%d\n"
	.size	.L.str18, 4

	.type	.L.str19,@object        # @.str19
.L.str19:
	.asciz	"%d\n"
	.size	.L.str19, 4

	.type	.Lstr20,@object         # @str20
.Lstr20:
	.asciz	"%f\n"
	.size	.Lstr20, 4

	.type	.Lstr21,@object         # @str21
.Lstr21:
	.asciz	"%f\n"
	.size	.Lstr21, 4

	.type	.Lstr22,@object         # @str22
.Lstr22:
	.asciz	"%f\n"
	.size	.Lstr22, 4

	.type	.Lstr23,@object         # @str23
.Lstr23:
	.asciz	"%f\n"
	.size	.Lstr23, 4

	.type	.L.str24,@object        # @.str24
.L.str24:
	.asciz	"%d\n"
	.size	.L.str24, 4

	.type	.L.str25,@object        # @.str25
.L.str25:
	.asciz	"%d\n"
	.size	.L.str25, 4

	.type	.L.str26,@object        # @.str26
.L.str26:
	.asciz	"%d\n"
	.size	.L.str26, 4

	.type	.L.str27,@object        # @.str27
.L.str27:
	.asciz	"%d\n"
	.size	.L.str27, 4

	.type	.Lstr28,@object         # @str28
.Lstr28:
	.asciz	"%f\n"
	.size	.Lstr28, 4

	.type	.Lstr29,@object         # @str29
.Lstr29:
	.asciz	"%f\n"
	.size	.Lstr29, 4

	.type	.Lstr30,@object         # @str30
.Lstr30:
	.asciz	"%f\n"
	.size	.Lstr30, 4

	.type	.Lstr31,@object         # @str31
.Lstr31:
	.asciz	"%f\n"
	.size	.Lstr31, 4

	.type	.L.str32,@object        # @.str32
.L.str32:
	.asciz	"%d\n"
	.size	.L.str32, 4

	.type	.Lstr33,@object         # @str33
.Lstr33:
	.asciz	"%f\n"
	.size	.Lstr33, 4

	.type	.L.str34,@object        # @.str34
.L.str34:
	.asciz	"%d\n"
	.size	.L.str34, 4

	.type	.Lstr35,@object         # @str35
.Lstr35:
	.asciz	"%f\n"
	.size	.Lstr35, 4

	.type	.L.str36,@object        # @.str36
.L.str36:
	.asciz	"%d\n"
	.size	.L.str36, 4

	.type	.Lstr37,@object         # @str37
.Lstr37:
	.asciz	"%f\n"
	.size	.Lstr37, 4

	.type	.L.str38,@object        # @.str38
.L.str38:
	.asciz	"%d\n"
	.size	.L.str38, 4

	.type	.Lstr39,@object         # @str39
.Lstr39:
	.asciz	"%f\n"
	.size	.Lstr39, 4

	.section	".note.GNU-stack","",@progbits
