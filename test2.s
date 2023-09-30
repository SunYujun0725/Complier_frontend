	.text
	.file	"test2.ll"
	.section	.rodata.cst4,"aM",@progbits,4
	.p2align	2               # -- Begin function main
.LCPI0_0:
	.long	1075838976              # float 2.5
.LCPI0_1:
	.long	1092616192              # float 10
	.section	.rodata.cst8,"aM",@progbits,8
	.p2align	3
.LCPI0_2:
	.quad	-4610920406684008448    # double -2.3399999141693115
	.text
	.globl	main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movl	$10, 20(%rsp)
	movl	$208, 16(%rsp)
	movl	$1075167887, 8(%rsp)    # imm = 0x4015C28F
	movl	$-1052571074, 12(%rsp)  # imm = 0xC1430A3E
	xorl	%eax, %eax
	testb	%al, %al
	jne	.LBB0_2
# %bb.1:                                # %L1
	movl	16(%rsp), %esi
	incl	%esi
	movl	%esi, 16(%rsp)
	movl	$.L.str0, %edi
	jmp	.LBB0_3
.LBB0_2:                                # %L2
	movl	20(%rsp), %esi
	incl	%esi
	movl	%esi, 20(%rsp)
	movl	$.L.str1, %edi
.LBB0_3:                                # %L3
	xorl	%eax, %eax
	callq	printf
	movss	8(%rsp), %xmm0          # xmm0 = mem[0],zero,zero,zero
	xorps	%xmm1, %xmm1
	ucomiss	%xmm1, %xmm0
	jb	.LBB0_5
# %bb.4:                                # %L4
	movss	8(%rsp), %xmm0          # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr2, %edi
	movb	$1, %al
	callq	printf
.LBB0_5:                                # %L5
	movss	8(%rsp), %xmm0          # xmm0 = mem[0],zero,zero,zero
	addss	.LCPI0_0(%rip), %xmm0
	movss	%xmm0, 8(%rsp)
	movss	.LCPI0_1(%rip), %xmm1   # xmm1 = mem[0],zero,zero,zero
	ucomiss	%xmm0, %xmm1
	jbe	.LBB0_7
# %bb.6:                                # %L6
	movss	8(%rsp), %xmm0          # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr3, %edi
	movb	$1, %al
	callq	printf
.LBB0_7:                                # %L7
	xorps	%xmm0, %xmm0
	ucomiss	12(%rsp), %xmm0
	jb	.LBB0_9
# %bb.8:                                # %L8
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr4, %edi
	jmp	.LBB0_10
.LBB0_9:                                # %L9
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr5, %edi
.LBB0_10:                               # %L10
	movb	$1, %al
	callq	printf
	movl	$0, 16(%rsp)
	movl	$0, 20(%rsp)
	xorl	%eax, %eax
	testb	%al, %al
	jne	.LBB0_12
# %bb.11:                               # %L11
	movl	$.Lstr6, %edi
	xorl	%eax, %eax
	callq	printf
.LBB0_12:                               # %L12
	movl	$-5, 20(%rsp)
	cmpl	$-5, 16(%rsp)
	je	.LBB0_14
# %bb.13:                               # %L13
	movl	$.Lstr7, %edi
	xorl	%eax, %eax
	callq	printf
.LBB0_14:                               # %L14
	movl	$-1072315761, 8(%rsp)   # imm = 0xC015C28F
	movsd	.LCPI0_2(%rip), %xmm0   # xmm0 = mem[0],zero
	movl	$.Lstr8, %edi
	movb	$1, %al
	callq	printf
	movl	$1075838976, 12(%rsp)   # imm = 0x40200000
	movss	8(%rsp), %xmm0          # xmm0 = mem[0],zero,zero,zero
	ucomiss	.LCPI0_0(%rip), %xmm0
	jne	.LBB0_15
	jnp	.LBB0_16
.LBB0_15:                               # %L15
	movl	$.Lstr9, %edi
	xorl	%eax, %eax
	callq	printf
.LBB0_16:                               # %L16
	movss	12(%rsp), %xmm0         # xmm0 = mem[0],zero,zero,zero
	movss	%xmm0, 8(%rsp)
	ucomiss	%xmm0, %xmm0
	jp	.LBB0_18
# %bb.17:                               # %L17
	movl	$.Lstr10, %edi
	xorl	%eax, %eax
	callq	printf
.LBB0_18:                               # %L18
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

	.type	.Lstr2,@object          # @str2
.Lstr2:
	.asciz	"c >= 0.0 %f\n"
	.size	.Lstr2, 13

	.type	.Lstr3,@object          # @str3
.Lstr3:
	.asciz	"c < 10.0 %f\n"
	.size	.Lstr3, 13

	.type	.Lstr4,@object          # @str4
.Lstr4:
	.asciz	"d <= 0.0 %f\n"
	.size	.Lstr4, 13

	.type	.Lstr5,@object          # @str5
.Lstr5:
	.asciz	"d > 0.0%f\n"
	.size	.Lstr5, 11

	.type	.Lstr6,@object          # @str6
.Lstr6:
	.asciz	"a = b\n"
	.size	.Lstr6, 7

	.type	.Lstr7,@object          # @str7
.Lstr7:
	.asciz	"a!=b\n"
	.size	.Lstr7, 6

	.type	.Lstr8,@object          # @str8
.Lstr8:
	.asciz	"%f\n"
	.size	.Lstr8, 4

	.type	.Lstr9,@object          # @str9
.Lstr9:
	.asciz	"c != d\n"
	.size	.Lstr9, 8

	.type	.Lstr10,@object         # @str10
.Lstr10:
	.asciz	"c == d\n"
	.size	.Lstr10, 8

	.section	".note.GNU-stack","",@progbits
