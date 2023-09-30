	.text
	.file	"test4.ll"
	.globl	main                    # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	pushq	%rbx
	.cfi_def_cfa_offset 16
	subq	$16, %rsp
	.cfi_def_cfa_offset 32
	.cfi_offset %rbx, -16
	movl	$10, 12(%rsp)
	movl	$0, 4(%rsp)
	movl	$0, 8(%rsp)
	cmpl	$10, 8(%rsp)
	jg	.LBB0_3
	.p2align	4, 0x90
.LBB0_2:                                # %L2
                                        # =>This Inner Loop Header: Depth=1
	movl	8(%rsp), %ebx
	incl	%ebx
	movl	12(%rsp), %esi
	incl	%esi
	movl	%esi, 12(%rsp)
	movl	$.L.str0, %edi
	xorl	%eax, %eax
	callq	printf
	movl	%ebx, 8(%rsp)
	cmpl	$10, 8(%rsp)
	jle	.LBB0_2
	jmp	.LBB0_3
	.p2align	4, 0x90
.LBB0_4:                                # %L5
                                        #   in Loop: Header=BB0_3 Depth=1
	movl	4(%rsp), %esi
	movl	$.L.str1, %edi
	xorl	%eax, %eax
	callq	printf
	incl	4(%rsp)
.LBB0_3:                                # %L4
                                        # =>This Inner Loop Header: Depth=1
	cmpl	$10, 4(%rsp)
	jle	.LBB0_4
# %bb.5:                                # %L6
	movl	4(%rsp), %esi
	movl	$.L.str2, %edi
	xorl	%eax, %eax
	callq	printf
	xorl	%eax, %eax
	addq	$16, %rsp
	.cfi_def_cfa_offset 16
	popq	%rbx
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

	.section	".note.GNU-stack","",@progbits
