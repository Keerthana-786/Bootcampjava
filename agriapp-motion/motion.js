// AgriApp Motion Bundle - motion.js
// Minimal, nature-inspired, performance-friendly helpers

(function () {
  const EASE = 'cubic-bezier(0.25, 1, 0.5, 1)';
  const DURATION = 360; // ms

  function prefersReducedMotion() {
    return window.matchMedia('(prefers-reduced-motion: reduce)').matches;
  }

  // 1) Page Transitions: add classes for enter/exit
  function transitionPage(enterEl, exitEl) {
    if (!enterEl && !exitEl) return;
    if (prefersReducedMotion()) {
      if (exitEl) exitEl.style.display = 'none';
      if (enterEl) enterEl.style.display = '';
      return;
    }

    if (exitEl) {
      exitEl.classList.remove('page-enter', 'page-enter-active');
      exitEl.classList.add('page-exit');
      requestAnimationFrame(() => exitEl.classList.add('page-exit-active'));
      setTimeout(() => (exitEl.style.display = 'none'), DURATION);
    }

    if (enterEl) {
      enterEl.style.display = '';
      enterEl.classList.remove('page-exit', 'page-exit-active');
      enterEl.classList.add('page-enter');
      requestAnimationFrame(() => enterEl.classList.add('page-enter-active'));
      setTimeout(() => enterEl.classList.remove('page-enter', 'page-enter-active'), DURATION);
    }
  }

  // 2) Count up animation for numbers
  function animateCount(el, toValue, { fromValue = 0, duration = 600, formatter } = {}) {
    if (!el) return;
    if (prefersReducedMotion()) { el.textContent = (formatter ? formatter(toValue) : String(toValue)); return; }

    const start = performance.now();
    const from = Number(fromValue);
    const to = Number(toValue);

    function step(now) {
      const t = Math.min(1, (now - start) / duration);
      const eased = easeOutCubic(t);
      const value = Math.round(from + (to - from) * eased);
      el.textContent = formatter ? formatter(value) : String(value);
      if (t < 1) requestAnimationFrame(step);
    }
    requestAnimationFrame(step);
  }

  function easeOutCubic(t) { return 1 - Math.pow(1 - t, 3); }

  // 3) Reveal on scroll
  function initRevealOnScroll({ selector = '.reveal', activeClass = 'reveal-active', rootMargin = '0px 0px -10% 0px' } = {}) {
    if (prefersReducedMotion()) {
      document.querySelectorAll(selector).forEach((el) => el.classList.add(activeClass));
      return;
    }

    const io = new IntersectionObserver((entries) => {
      for (const entry of entries) {
        if (entry.isIntersecting) {
          entry.target.classList.add(activeClass);
          io.unobserve(entry.target);
        }
      }
    }, { rootMargin, threshold: 0.1 });

    document.querySelectorAll(selector).forEach((el) => io.observe(el));
    return io;
  }

  // 4) Parallax background on scroll (translateY small amounts)
  function initParallax({ selector = '.parallax', intensity = 0.2 } = {}) {
    const els = Array.from(document.querySelectorAll(selector));
    if (!els.length) return () => {};
    if (prefersReducedMotion()) return () => {};

    function onScroll() {
      const y = window.scrollY || window.pageYOffset;
      for (const el of els) {
        el.style.transform = `translateY(${-(y * intensity)}px)`;
      }
    }
    onScroll();
    window.addEventListener('scroll', onScroll, { passive: true });
    return () => window.removeEventListener('scroll', onScroll);
  }

  // 5) Chat typing indicator helper: returns an element
  function createTypingIndicator() {
    const wrapper = document.createElement('span');
    wrapper.className = 'typing-indicator';
    wrapper.innerHTML = '<span class="dot"></span><span class="dot"></span><span class="dot"></span>';
    return wrapper;
  }

  // 6) Bell shake utility
  function shakeBell(bellEl) {
    if (!bellEl) return;
    bellEl.classList.remove('bell-shake');
    // Force reflow to restart animation
    void bellEl.offsetWidth; 
    bellEl.classList.add('bell-shake');
  }

  // 7) Helper to flash background for up/down changes
  function flashChange(el, direction) {
    if (!el) return;
    const up = direction === 'up';
    const cls = up ? 'price-change-up' : 'price-change-down';
    el.classList.add(cls);
    setTimeout(() => el.classList.remove(cls), 1000);
  }

  // 8) Result reveal (scale + fade)
  function reveal(el) {
    if (!el) return;
    if (prefersReducedMotion()) { el.classList.add('result-reveal-active'); return; }
    el.classList.add('result-reveal');
    requestAnimationFrame(() => el.classList.add('result-reveal-active'));
    setTimeout(() => el.classList.remove('result-reveal'), DURATION);
  }

  // 9) Stagger in children with fade-up classes
  function staggerFadeUp(container, { baseDelay = 100 } = {}) {
    if (!container) return;
    const children = Array.from(container.children);
    children.forEach((child, i) => {
      child.classList.add('fade-up');
      child.style.animationDelay = `${(i + 1) * baseDelay}ms`;
    });
  }

  // Expose minimal API
  window.AgriMotion = {
    transitionPage,
    animateCount,
    initRevealOnScroll,
    initParallax,
    createTypingIndicator,
    shakeBell,
    flashChange,
    reveal,
    staggerFadeUp,
    prefersReducedMotion
  };
})();
