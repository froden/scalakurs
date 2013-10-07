eaui.addListener('#repl-input', function () {
    var exprInput = $('#cmd-e');
    var output = $('#repl-output');
    var form = $('#repl-input');
    var action = form.attr('action');
    var currentExpr = '';
    var currentIdx = -1;

    form.bind('submit.eaui', function (ev) {
        $('.prompt', output).remove();
        var ph = eaui.placeholder();
        output.append(ph);
        var params = $(':input:visible', form).serializeArray();
        params.push({
            name: '__',
            value: new Date().getTime().toString()
        });
        flushHistory();
        $.ajax({
            url: action,
            type: 'post',
            data: params,
            dataType: 'html',
            success: function (data) {
                ph.replaceWith(data);
            },
            error: eaui.processAjaxError
        });
        ev.preventDefault();
        return false;
    });

    function flushHistory() {
        if (window.localStorage) {
            var history = getHistory();
            history.unshift(exprInput.val());
            if (history.length > 100)
                history = history.slice(0, 99);
            localStorage.setItem('scalaconsole.history', JSON.stringify(history));
        }
        // Clear the field and state
        exprInput.val('').focus();
        currentExpr = '';
        currentIdx = -1;
    }

    function getHistory() {
        var history = [];
        if (window.localStorage) {
            try {
                history = JSON.parse(localStorage.getItem('scalaconsole.history'));
                if (!history)
                    history = [];
            } catch (e) {
            }
        }
        return history;
    }

    if (window.localStorage) {
        exprInput.bind('keydown.eaui', function (ev) {
            var input = $(this);
            if (ev.keyCode == 0x26) {
                // Up button
                ev.preventDefault();
                var h1 = getHistory();
                if ((currentIdx + 1) < h1.length) {
                    currentIdx += 1;
                    input.val(h1[currentIdx]);
                }
                return false;
            } else if (ev.keyCode == 0x28) {
                // Down button
                ev.preventDefault();
                var h2 = getHistory();
                if (currentIdx > 0) {
                    currentIdx -= 1;
                    input.val(h2[currentIdx]);
                } else if (currentIdx == 0) {
                    currentIdx = -1;
                    input.val(currentExpr);
                }
                return false;
            }
        });
        exprInput.bind('keyup.eaui', function (ev) {
            if (currentIdx == -1)
                currentExpr = $(this).val();
        });
    }
});
