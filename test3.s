	.text
	.file	"test3.ll"
	.globl	main                    # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	movl	$10, (%rsp)
	movl	$1075000115, 4(%rsp)    # imm = 0x40133333
	movl	$.Lstr0, %edi
	xorl	%eax, %eax
	callq	printf
	movl	$.Lstr1, %edi
	xorl	%eax, %eax
	callq	printf
	movl	(%rsp), %esi
	movl	$.L.str2, %edi
	xorl	%eax, %eax
	callq	printf
	movss	4(%rsp), %xmm0          # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr3, %edi
	movb	$1, %al
	callq	printf
	movl	(%rsp), %esi
	movl	$.L.str4, %edi
	xorl	%eax, %eax
	callq	printf
	movss	4(%rsp), %xmm0          # xmm0 = mem[0],zero,zero,zero
	cvtss2sd	%xmm0, %xmm0
	movl	$.Lstr5, %edi
	movb	$1, %al
	callq	printf
	xorl	%eax, %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc
                                        # -- End function
	.type	.Lstr0,@object          # @str0
	.section	.rodata.str1.1,"aMS",@progbits,1
.Lstr0:
	.asciz	"Hello world\n"
	.size	.Lstr0, 13

	.type	.Lstr1,@object          # @str1
.Lstr1:
	.asciz	"Hello world"
	.size	.Lstr1, 12

	.type	.L.str2,@object         # @.str2
.L.str2:
	.asciz	"a: %d\n"
	.size	.L.str2, 7

	.type	.Lstr3,@object          # @str3
.Lstr3:
	.asciz	"b: %f\n"
	.size	.Lstr3, 7

	.type	.L.str4,@object         # @.str4
.L.str4:
	.asciz	"a: %d"
	.size	.L.str4, 6

	.type	.Lstr5,@object          # @str5
.Lstr5:
	.asciz	"b: %f"
	.size	.Lstr5, 6

	.section	".note.GNU-stack","",@progbits
